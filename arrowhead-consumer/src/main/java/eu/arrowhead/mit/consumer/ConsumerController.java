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
	@RequestMapping(value = MITConstants.MIT_CONSUMER_CLTC_ARRAY_SINGLE_URI, method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	ResponseEntity<String> ClosedLoopTemperatureControlArraySingleEntry(@PathVariable int runs, @PathVariable int currentRun) {
		String ret = "";

		double temperatureValue = 0;
		String ACSystem = MITConstants.MIT_AIR_CONDITIONING_SYSTEM_OFF;
			try {
				temperatureValue = Double.parseDouble(cc.getCLTCArrayService(runs, currentRun));
				if (temperatureValue > MITConstants.TEMPERATURE_LIMIT) {
					ACSystem = MITConstants.MIT_AIR_CONDITIONING_SYSTEM_ON;
				} else {
					ACSystem = MITConstants.MIT_AIR_CONDITIONING_SYSTEM_OFF;
				}

				ret += "\n Temperature Sensor: " + temperatureValue + " °C \n Air-Conditioning System: " + ACSystem
						+ "\n";
			} catch (IOException e) {
				e.printStackTrace();
			}
	

		return new ResponseEntity<String>(ret, HttpStatus.OK);
	}
}
