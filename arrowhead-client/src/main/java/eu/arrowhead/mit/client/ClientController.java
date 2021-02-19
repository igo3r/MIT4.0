package eu.arrowhead.mit.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
//import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import eu.arrowhead.common.CommonConstants;
import eu.arrowhead.common.CoreCommonConstants;
import eu.arrowhead.common.Defaults;
import eu.arrowhead.common.mit.MITConstants;
import eu.arrowhead.mit.utils.ClientConnection;
import eu.arrowhead.mit.utils.ClientProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = { CoreCommonConstants.SWAGGER_TAG_ALL })
@CrossOrigin(maxAge = Defaults.CORS_MAX_AGE, allowCredentials = Defaults.CORS_ALLOW_CREDENTIALS, allowedHeaders = {
		HttpHeaders.ORIGIN, HttpHeaders.CONTENT_TYPE, HttpHeaders.ACCEPT, HttpHeaders.AUTHORIZATION })
@RestController
@RequestMapping(MITConstants.MIT_CLIENT_URI)
public class ClientController extends Thread {

	private final Logger logger = LogManager.getLogger(ClientController.class);
	private final BlockingQueue<RunParams> runQueue = new ArrayBlockingQueue<ClientController.RunParams>(10);
	private final AtomicBoolean running = new AtomicBoolean(false);

	@Autowired
	private ClientConnection cc;

	ClientProperties cp = new ClientProperties();

	@GetMapping(path = CommonConstants.ECHO_URI)
	public String echoService() {
		return "Got it!";
	}

	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "innerLoop: Please enter an even number between 0 and 1000. \n innerTimeout: Please enter a time in seconds for a break after each innerLoop-testrun. \n outerLoop: Please enter a number to set how often the innerLoops should be performed. \n outerTimeout: Please enter a time in seconds for a break after each outerLoop-testrun."),
			@ApiResponse(code = 406, message = "Please follow the instructions. You entered not acceptable numbers."),
	})
	@RequestMapping(value = MITConstants.MIT_CLIENT_RUN_URI_WITH_PARAMS, method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	ResponseEntity<Void> TestRun(@PathVariable final int outerLoop, @PathVariable final long outerTimeout,
			@PathVariable final int innerLoop, @PathVariable final long innerTimeout) throws IOException {
		runQueue.offer(new RunParams(outerLoop, outerTimeout, innerLoop, innerTimeout));
		return ResponseEntity.ok().build();
	}

	@PostConstruct
	protected void postSetup() {
		running.getAndSet(true);
		start();
	}

	@PreDestroy
	protected void preDestroy() {
		running.getAndSet(false);
	}

	@Override
	public void run() {
		RunParams rp;
		ResponseEntity<String> result = null;
		String c2_path; 
		while (running.get()) {
			try {
				Properties prop = cp.getProp();
				c2_path = prop.getProperty(MITConstants.PROPERTY_C2_PATH);
				do {
					rp = runQueue.poll(5, TimeUnit.SECONDS);
				} while (running.get() && Objects.isNull(rp));

				if (!running.get()) {
					break;
				}

				logger.info("Starting new run with parameters:");
				logger.info("OuterLoop/OuterTimeout: {}{}", rp.outerLoop, rp.outerTimeout);
				logger.info("InnerLoop/InnerTimeout: {}{}", rp.innerLoop, rp.innerTimeout);
				for (int i = 1; (i - 1) < rp.outerLoop; i++) {
					logger.info("");
					logger.info("[----------------------- Start - Outer: {} -----------------------]", i);

					for (int j = 1; (j - 1) < rp.innerLoop; j++) {
						try {
							logger.info("");
							logger.info("[Start - Inner: {}]", j);

							if (c2_path != null) {
								result = cc.run(rp.innerLoop, j);
							} else {
								logger.info("There is no path in the application.properties file.");
							}

							if (result.getStatusCode().is2xxSuccessful()) {
								logger.info("[Run - Outer: {}, Inner: {}]: {}", i, j, result.getBody());
							}
						} catch (IOException e) {
							logger.error(e.getMessage(), e);
						}

						logger.info("[Stop - Inner: {}]", j);
						logger.debug("[Sleep - Inner: {}]", j);
						mysleep(rp.innerTimeout);
					}
					logger.info("");
					logger.info("[----------------------- Stop - Outer: {} ------------------------]", i);
					logger.info("");
					logger.debug("[Sleep - Outer: {}]", i);
					mysleep(rp.outerTimeout);

				}
			} catch (final Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
	}

	private void mysleep(final long timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			logger.fatal(e);
		}
	}

	private static class RunParams {
		final int outerLoop;
		final long outerTimeout;
		final int innerLoop;
		final long innerTimeout;

		public RunParams(int outerLoop, long outerTimeout, int innerLoop, long innerTimeout) {
			super();
			this.outerLoop = outerLoop;
			this.outerTimeout = outerTimeout;
			this.innerLoop = innerLoop;
			this.innerTimeout = innerTimeout;
		}
	}

	public Properties getProp() throws IOException {
		Properties prop = new Properties();

		String propFileName = MITConstants.PROPERTY_FILE_NAME;
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		if (inputStream != null) {
			prop.load(inputStream);
			return prop;
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
	}
}
