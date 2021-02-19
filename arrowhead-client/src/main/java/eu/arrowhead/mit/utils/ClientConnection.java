package eu.arrowhead.mit.utils;


import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;

import eu.arrowhead.common.CommonConstants;
import eu.arrowhead.common.Utilities;
import eu.arrowhead.common.http.HttpService;
import eu.arrowhead.common.mit.MITConstants;

@Component
public class ClientConnection {
	@Autowired
	private HttpService httpService;

	public ResponseEntity<String> run(int runs, int currentRun) throws IOException {
		ResponseEntity<String> retResult = null;
		ClientProperties cp = new ClientProperties();
		Properties prop = cp.getProp();

		String securityMode = prop.getProperty(MITConstants.SECURITY_MODE);
		String scheme = "";

		if (securityMode.equals("false")) {
			scheme = CommonConstants.HTTP;
		} else {
			scheme = CommonConstants.HTTPS;
		}
		System.out.println("Scheme in ClientConnection " + scheme);
		UriComponents providerUri = Utilities.createURI(scheme, prop.getProperty(MITConstants.PROPERTY_C2_ADDRESS),
				Integer.valueOf(prop.getProperty(MITConstants.PROPERTY_C2_PORT)),
				prop.getProperty(MITConstants.PROPERTY_C2_PATH));
		System.out.println("Providerui in Clientconnection " + providerUri);

		retResult = httpService.sendRequest(providerUri, HttpMethod.GET, String.class);
		return retResult;
	}

}
