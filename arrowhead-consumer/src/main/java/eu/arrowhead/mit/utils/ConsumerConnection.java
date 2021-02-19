//package eu.arrowhead.mit.utils;
//
//import java.util.Properties;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.util.UriComponents;
//
//import eu.arrowhead.common.CommonConstants;
//import eu.arrowhead.common.Utilities;
//import eu.arrowhead.common.dto.shared.OrchestrationFlags;
//import eu.arrowhead.common.dto.shared.OrchestrationFlags.Flag;
//import eu.arrowhead.common.dto.shared.OrchestrationFormRequestDTO;
//import eu.arrowhead.common.dto.shared.OrchestrationResponseDTO;
//import eu.arrowhead.common.dto.shared.ServiceQueryFormDTO;
//import eu.arrowhead.common.dto.shared.SystemRequestDTO;
//import eu.arrowhead.common.dto.shared.SystemResponseDTO;
//import eu.arrowhead.common.http.HttpService;
//import eu.arrowhead.common.mit.MITConstants;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//
//@Component
//public class ConsumerConnection {
//	@Autowired
//	private HttpService httpService;
//
//	public Properties getProp() throws IOException {
//		Properties prop = new Properties();
//
//		String propFileName = MITConstants.PROPERTY_FILE_NAME;
//		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
//
//		if (inputStream != null) {
//			prop.load(inputStream);
//			return prop;
//		} else {
//			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
//		}
//	}
//
//	public UriComponents createOSUri(final String scheme) throws IOException {
//		final String osUriStr = CommonConstants.ORCHESTRATOR_URI + CommonConstants.OP_ORCH_PROCESS;
//		String osAddress = null;
//		int osPort = 0;
//		Properties prop = getProp();
//
//		if (prop != null) {
//			osAddress = prop.getProperty(MITConstants.ORCHESTRATOR_ADDRESS);
//			osPort = Integer.valueOf(prop.getProperty(MITConstants.ORCHESTRATOR_PORT));
//		}
//
//		return Utilities.createURI(scheme, osAddress, osPort, osUriStr);
//	}
//
//	public ResponseEntity<String> getStatus(String scheme, SystemResponseDTO provider, String uri) throws IOException {
//		ResponseEntity<String> retTemp = null;
//		UriComponents providerUri = Utilities.createURI(scheme, provider.getAddress(), provider.getPort(), uri);
//		retTemp = httpService.sendRequest(providerUri, HttpMethod.GET, String.class);
//
//		return retTemp;
//	}
//
//	public OrchestrationResponseDTO getProducer(String scheme, Properties prop, String pName) throws IOException {
//		UriComponents osUri = createOSUri(scheme);
//		String securityMode = prop.getProperty(MITConstants.SECURITY_MODE);
//		ServiceQueryFormDTO serviceForm;
//
//		// create and configure system request for the requesting system
//		SystemRequestDTO sr = new SystemRequestDTO();
//		sr.setSystemName(MITConstants.MIT_CONSUMER_SYSTEM_NAME);
//		sr.setAddress(prop.getProperty(MITConstants.SERVER_ADDRESS));
//		sr.setPort(Integer.valueOf(prop.getProperty(MITConstants.SERVER_PORT)));
//
//		// create and configure service form for the requested service
//		if (securityMode.equals("false")) {
//			serviceForm = new ServiceQueryFormDTO.Builder(pName).interfaces(CommonConstants.HTTP_INSECURE_JSON).build();
//		} else {
//			serviceForm = new ServiceQueryFormDTO.Builder(pName).interfaces(CommonConstants.HTTP_SECURE_JSON).build();
//		}
//
//		// set orchestration flags
//		OrchestrationFlags flags = new OrchestrationFlags();
//		// use dynamic orchestration with this flag
//		flags.put(Flag.OVERRIDE_STORE, true);
//		// if more entries are found, return only one
//		flags.put(Flag.MATCHMAKING, true);
//
//		// create and configure orchestration request
//		OrchestrationFormRequestDTO ofr = new OrchestrationFormRequestDTO.Builder(sr).requestedService(serviceForm)
//				.flags(flags).build();
//
//		// get orchestration response
//		return new OrchestrationResponseDTO(httpService
//				.sendRequest(osUri, HttpMethod.POST, OrchestrationResponseDTO.class, ofr).getBody().getResponse());
//	}
//
////
////	public String turnAirConditionOn() throws IOException {
////		return useDifferentServices(MITConstants.MIT_PRODUCER_SERVICE_GET_STATUS); 
////	}
//	
//	
//	public String turnAirConditionOn() throws IOException {
//		String retEntity = "";
//		Properties prop = getProp();
//		String securityMode = prop.getProperty(MITConstants.SECURITY_MODE);
//		String scheme = "";
//		
//		if(securityMode.equals("false")) 
//		{
//			scheme = CommonConstants.HTTP;
//		} else {
//			scheme = CommonConstants.HTTPS;
//		}
//		
//		
//		OrchestrationResponseDTO orchestrationResponse = getProducer(scheme, prop,
//				MITConstants.MIT_PRODUCER_SERVICE_GET_STATUS);
//
//		if (!orchestrationResponse.getResponse().isEmpty()) {
//			retEntity = getStatus(scheme, orchestrationResponse.getResponse().get(0).getProvider(),
//					orchestrationResponse.getResponse().get(0).getServiceUri()).getBody();
//		}
//		return retEntity;
//	}
//	
//
//}
