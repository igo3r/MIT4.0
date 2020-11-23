package eu.arrowhead.mit.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.arrowhead.common.CommonConstants;
import eu.arrowhead.common.CoreCommonConstants;
import eu.arrowhead.common.Defaults;
import eu.arrowhead.common.mit.MITConstants;
import eu.arrowhead.mit.utils.ProducerAirCondition;
import io.swagger.annotations.Api;

@Api(tags = { CoreCommonConstants.SWAGGER_TAG_ALL })
@CrossOrigin(maxAge = Defaults.CORS_MAX_AGE, allowCredentials = Defaults.CORS_ALLOW_CREDENTIALS, 
			 allowedHeaders = { HttpHeaders.ORIGIN, HttpHeaders.CONTENT_TYPE, HttpHeaders.ACCEPT, HttpHeaders.AUTHORIZATION }
)
@RestController
@RequestMapping(MITConstants.MIT_PRODUCER_URI)
public class ProducerController {
	
	@Autowired
	private ProducerAirCondition pac;
	
	@GetMapping(path = CommonConstants.ECHO_URI)
	public String echoService() {
		return "Got it!";
	}
	
	@RequestMapping(value = MITConstants.MIT_PRODUCER_GET_STATUS_URI, method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	ResponseEntity<String> turnAirConditionOn() {
		return new ResponseEntity<String>(pac.turnAirConditionOn(), HttpStatus.OK);
	}
}
