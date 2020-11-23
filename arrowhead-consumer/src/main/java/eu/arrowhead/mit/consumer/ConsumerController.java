package eu.arrowhead.mit.consumer;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
import eu.arrowhead.mit.utils.ConsumerConnection;
import eu.arrowhead.mit.utils.ConsumerTempGenerator;
import eu.arrowhead.common.mit.MITConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = { CoreCommonConstants.SWAGGER_TAG_ALL })
@CrossOrigin(maxAge = Defaults.CORS_MAX_AGE, allowCredentials = Defaults.CORS_ALLOW_CREDENTIALS, allowedHeaders = {
		HttpHeaders.ORIGIN, HttpHeaders.CONTENT_TYPE, HttpHeaders.ACCEPT, HttpHeaders.AUTHORIZATION })
@RestController
@RequestMapping(MITConstants.MIT_CONSUMER_URI)
public class ConsumerController {
	@Autowired
	private ConsumerConnection cc;

	@GetMapping(path = CommonConstants.ECHO_URI)
	public String echoService() {
		return "Got it!";
	}

	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Runs: Please enter an even number between 0 and 1000 \n currentRun: Enter a number below runs."),
			@ApiResponse(code = 406, message = "Please follow the instructions. You entered not acceptable numbers."),
	})
	@RequestMapping(value = MITConstants.MIT_CONSUMER_TEMPERATURE_ARRAY_SINGLE_URI, method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	ResponseEntity<String> TemperatureArraySingleEntry(@PathVariable int runs, @PathVariable int currentRun)
			throws IOException {
		String ret = "";
		int runBound = runs / 2;
		ConsumerTempGenerator ctg = new ConsumerTempGenerator();
		double temperatureValue = 0.0;
		if (runs <= 1000 && currentRun <= runs && (runs % 2 == 0)) {
			temperatureValue = ctg.getTemperatureArray(currentRun - 1, runBound);
			if (temperatureValue > MITConstants.TEMPERATURE_LIMIT) {
				ret = "\n Temperature Sensor: " + temperatureValue + " °C" + "\n" + " Air-Conditioning System: "
						+ cc.turnAirConditionOn() + "\n";
			} else {
				ret = "\n Temperature Sensor: " + temperatureValue + " °C" + "\n" + " Air-Conditioning System: OFF \n";
			}
		} else {
			ret = "Please enter an even number between 1 and 1000!";
		}
		return new ResponseEntity<String>(ret, HttpStatus.OK);
	}
}
