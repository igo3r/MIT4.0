package eu.arrowhead.mit.producer;

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
import eu.arrowhead.common.mit.MITConstants;
import eu.arrowhead.mit.utils.ProducerSensorControl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = { CoreCommonConstants.SWAGGER_TAG_ALL })
@CrossOrigin(maxAge = Defaults.CORS_MAX_AGE, allowCredentials = Defaults.CORS_ALLOW_CREDENTIALS, 
			 allowedHeaders = { HttpHeaders.ORIGIN, HttpHeaders.CONTENT_TYPE, HttpHeaders.ACCEPT, HttpHeaders.AUTHORIZATION }
)
@RestController
@RequestMapping(MITConstants.MIT_PRODUCER_URI)
public class ProducerController {

	@Autowired
	private ProducerSensorControl psc;
	
	@GetMapping(path = CommonConstants.ECHO_URI)
	public String echoService() {
		return "Got it!";
	}
	
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Please enter an even number between 0 and 1000 for runs, and currentRun a number below runs."),
	})
	@RequestMapping(value = MITConstants.MIT_PRODUCER_GET_ARRAY_URI, method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	ResponseEntity<String> getRoomTemperatureArray(@PathVariable int runs, @PathVariable int currentRun) {
		return new ResponseEntity<String>(psc.getSensorDataArray(runs, currentRun), HttpStatus.OK);
	}
	
	

}
