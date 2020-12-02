package eu.arrowhead.mit.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import eu.arrowhead.common.mit.MITConstants;

public class ClientProperties {
	public Properties getProp() throws IOException {
		Properties prop = new Properties();
		
		String propFileName = MITConstants.PROPERTY_FILE_NAME;
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		
		if(inputStream != null) {
			prop.load(inputStream);
			return prop;
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
	}
}
