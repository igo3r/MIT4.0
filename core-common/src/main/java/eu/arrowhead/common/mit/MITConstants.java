package eu.arrowhead.common.mit;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public interface MITConstants {
	/* --- Common constants --- */
	public static final String SECURE_PROTOCOL = "https://";
	public static final String INSECURE_PROTOCOL = "http://";
	public static final String PORT_COLON = ":";
	public static final String GET_REQUEST_METHOD = "GET";
	public static final String ACCEPT_REQUEST_PROPERTY_KEYWORD = "Accept";
	public static final String ACCEPT_REQUEST_PROPERTY_VALUE = "text/plain";
	public static final String PROPERTY_FILE_NAME = "application.properties";
	public static final DateFormat SDF = new SimpleDateFormat("[dd.MM.yyyy, HH:mm:ss.SSS]: ");
	
	public static final int MIT_MAX_TASKS = 1000;

	/* --- Consumer constants --- */
	public static final String PROPERTY_C1_ADDRESS = "c1_address";
	public static final String PROPERTY_C1_PATH = "c1_path";
	public static final String PROPERTY_C1_PORT = "c1_port";
	
	public static final String MIT_SYSTEM_CONSUMER = "Consumer";
	public static final String MIT_CONSUMER_URI = "/consumer";
	public static final String MIT_SERVICE_CLTC_ARRAY_SINGLE = "cltc_array_single";
	public static final String MIT_CONSUMER_CLTC_ARRAY_SINGLE_URI = "/cltc_array_single/{runs}/{currentRun}";
	public static final String MIT_CONSUMER_SYSTEM_NAME = "consumer";
	
	
	/* --- Producer Constants --- */
	public static final String PROPERTY_C2_ADDRESS = "c2_address";
	public static final String PROPERTY_C2_PATH = "c2_path";
	public static final String PROPERTY_C2_PORT = "c2_port";
	
	public static final String MIT_SYSTEM_PRODUCER = "Producer";
	public static final String MIT_PRODUCER_URI = "/producer";
	public static final String MIT_PRODUCER_SERVICE_GET_ARRAY = "get_array";
	public static final String MIT_PRODUCER_GET_ARRAY_URI = "/get_array/{runs}/{currentRun}";
	public static final String MIT_PRODUCER_GET_ARRAY_URI_CONNECTION = "/get_array";
	public static final String MIT_PRODUCER_SYSTEM_NAME = "producer";
	
	/* --- Producer(C2) upper- and lower-boundaries for temperature measurement --- */
	public static final double MAX_MEASUREMENT_VALUE = 30.0;
	public static final double MIN_MEASUREMENT_VALUE = 20.0;
	public static final double TEMPERATURE_LIMIT = 25.0;
	
	/* ---  Core Systems --- */
	
	public static final String ORCHESTRATOR_ADDRESS = "os_address";
	public static final String ORCHESTRATOR_PORT = "os_port";
	
	public static final String SERVER_ADDRESS = "server.address";
	public static final String SERVER_PORT = "server.port";
	public static final String SECURITY_MODE= "server.ssl.enabled"; 
	
	public static final String MIT_AIR_CONDITIONING_SYSTEM_OFF = "OFF";
	public static final String MIT_AIR_CONDITIONING_SYSTEM_ON = "ON";
	
	public static final String MIT_SYSTEM_CLIENT = "Client";
	public static final String MIT_CLIENT_URI = "/client";
	public static final String MIT_CLIENT_SERVICE_RUN = "run";
	public static final String MIT_CLIENT_RUN_URI = "/run";
	public static final String MIT_CLIENT_RUN_URI_WITH_PARAMS = "/run/{outerLoop}/{outerTimeout}/{innerLoop}/{innerTimeout}";
	
	public static final int MIT_DEFAULT_CONSUMER_PORT = 2241;
	public static final int MIT_DEFAULT_PRODUCER_PORT = 2242;
	public static final int MIT_DEFAULT_CLIENT_PORT = 2248;
	public static final String PARAMETER_ID = "id";
	
	
	/* --- ARRAYS --- */
	
	public static final double[] VALUES_TEMPERATURE_HIGH = {26.8,28.0,28.7,30.0,28.0,25.5,28.4,25.3,25.7,25.1,29.6,26.7,25.4,29.4,27.0,28.5,28.5,29.9,28.9,30.0,25.1,29.0,26.9,27.8,25.9,28.6,30.0,29.0,28.5,25.4,27.9,28.7,30.0,25.7,26.6,28.5,29.9,27.2,28.7,29.0,26.1,29.9,26.4,26.0,29.3,28.3,25.3,26.5,26.8,28.0,26.8,26.2,25.2,26.4,25.2,28.4,29.6,27.0,28.5,28.0,25.4,27.8,28.4,25.3,25.3,25.5,28.2,29.8,27.3,29.2,29.3,25.2,26.1,29.0,26.8,28.5,27.5,27.8,26.2,26.2,28.8,28.2,26.3,26.2,29.5,26.5,27.5,25.3,27.7,26.4,27.3,26.9,26.4,25.5,26.8,27.7,28.0,27.5,26.8,27.1,27.5,28.3,25.6,28.8,29.3,27.5,25.9,27.1,27.4,25.2,29.8,26.2,27.1,29.0,28.5,29.8,26.2,27.9,29.7,26.4,29.0,27.2,27.4,27.0,28.0,25.3,25.5,28.0,25.5,25.4,27.8,25.9,28.2,28.2,29.1,27.3,28.4,26.2,27.0,26.4,28.8,27.5,26.5,28.8,25.9,28.6,29.1,27.7,26.8,26.0,27.5,26.4,25.3,26.4,28.8,29.2,27.2,28.6,26.0,27.0,25.8,25.1,28.6,26.1,27.0,27.1,27.1,26.7,28.2,29.4,26.4,25.5,27.2,26.1,26.5,27.4,26.1,28.0,25.4,27.3,29.4,28.5,29.0,26.0,26.8,26.6,27.2,27.1,26.2,26.1,26.2,28.0,27.7,27.6,26.0,25.3,26.8,25.6,28.7,29.5,29.6,27.4,27.0,26.2,28.0,29.6,28.4,27.3,27.7,29.1,26.7,30.0,26.0,27.7,25.7,28.1,26.1,26.6,26.5,27.2,26.9,27.8,26.2,26.0,27.5,25.3,25.8,27.9,28.1,29.3,29.6,27.5,26.5,25.7,27.9,26.5,25.3,29.1,25.7,29.7,25.4,28.0,25.8,26.7,25.8,26.6,28.4,27.7,29.4,25.4,28.0,28.2,30.0,26.9,27.3,26.4,26.5,26.7,27.7,25.4,26.5,26.2,26.6,28.4,28.9,29.6,29.6,25.6,29.6,27.4,28.9,27.3,29.0,27.0,28.5,26.1,27.5,25.3,28.4,29.1,27.2,26.3,29.8,27.5,28.3,27.8,27.0,29.0,27.2,26.8,29.9,28.4,28.2,26.3,28.5,26.7,26.6,26.9,28.9,25.9,26.3,26.8,29.3,27.5,29.6,26.2,25.9,25.8,28.9,27.7,25.6,28.5,30.0,29.0,27.6,28.4,25.5,28.0,29.6,29.7,25.6,29.1,26.9,27.3,29.8,26.2,28.3,26.8,27.0,29.3,29.3,25.8,29.5,27.5,25.5,27.8,25.5,28.9,25.7,27.0,25.1,28.7,26.6,26.3,27.0,25.2,27.3,26.2,25.4,27.5,29.9,27.0,27.8,26.4,27.1,26.6,27.2,25.2,26.2,29.6,27.7,26.6,29.0,25.6,25.9,26.7,26.3,27.9,29.1,26.1,25.3,25.2,28.3,28.7,27.4,28.7,25.5,29.7,25.2,26.3,27.6,27.4,28.2,25.2,28.5,29.2,26.2,25.3,27.4,25.9,28.1,28.2,29.7,29.8,25.3,29.4,29.3,28.2,27.8,29.7,28.6,27.0,27.5,26.5,27.5,30.0,30.0,28.3,27.6,28.5,25.3,25.6,25.5,25.5,25.3,28.3,28.0,25.2,25.1,28.0,26.3,25.3,25.3,25.2,29.5,27.3,29.4,28.5,30.0,26.6,26.5,27.0,28.4,27.4,27.4,30.0,27.2,27.1,26.7,27.8,27.6,25.4,27.2,26.0,25.3,26.7,29.8,27.9,27.4,26.0,27.7,30.0,26.3,27.9,28.4,28.9,25.2,29.0,29.5,26.8,28.9,29.5,29.1,26.2,25.1,27.2,29.3,25.5,29.9,25.9,26.6,28.2,29.2,29.2,29.4,26.5,25.5,28.3,28.7,26.9,25.2,29.5,25.7,29.3,25.2,25.7,27.4,29.0,26.5,29.7,25.1,28.8,28.0,28.8,25.4,30.0,29.2,27.9,26.2,28.9};

	public static final double[] VALUES_TEMPERATURE_LOW = {24.6,23.4,20.2,23.4,22.2,21.0,20.9,24.7,20.8,23.8,22.1,20.8,22.0,20.4,24.2,20.5,23.4,24.6,22.1,20.6,21.2,24.3,24.4,21.1,24.0,23.7,22.0,22.0,24.3,20.3,24.6,23.5,23.4,22.5,21.9,21.6,21.5,20.2,20.6,23.8,23.1,20.0,22.4,24.9,21.8,25.0,20.7,20.5,23.2,24.9,22.1,23.9,20.6,24.0,23.0,23.2,21.7,21.9,23.4,20.5,24.7,23.4,22.4,21.2,20.0,24.8,21.8,23.2,20.9,22.1,23.6,24.6,23.0,25.0,22.6,24.5,20.1,23.1,22.7,20.8,21.9,24.1,24.9,24.2,22.0,22.1,22.0,22.4,23.7,23.3,21.1,21.7,21.2,20.2,22.6,24.2,22.0,20.3,24.5,23.1,21.6,21.3,23.4,24.4,22.6,20.9,25.0,24.8,20.6,21.3,20.6,22.0,21.1,21.9,24.6,21.0,21.9,21.0,22.2,22.4,24.3,22.2,20.5,20.3,23.1,22.6,24.5,21.5,24.6,23.5,23.6,20.3,24.6,24.3,21.1,23.5,20.3,24.1,24.7,24.9,24.5,24.3,24.1,22.5,24.8,24.5,20.2,20.6,21.2,20.4,22.1,24.6,20.5,22.6,21.3,20.1,23.9,20.9,24.5,21.2,22.7,21.5,24.7,21.4,20.1,23.1,20.3,23.4,20.5,23.9,24.0,23.6,24.3,23.9,24.8,21.5,24.2,24.5,20.0,20.7,21.4,21.6,20.3,21.7,20.6,23.6,20.1,21.3,23.0,23.5,21.5,21.6,24.2,22.2,23.6,21.0,20.3,24.0,24.5,21.5,23.9,21.6,21.8,22.0,23.0,24.5,20.9,20.6,22.4,23.7,21.6,20.2,20.4,21.0,21.8,22.6,20.7,20.9,22.1,21.5,24.0,22.5,25.0,24.5,20.4,23.0,20.8,21.5,20.3,22.8,24.0,23.0,21.3,24.3,20.9,20.7,23.0,21.7,20.5,20.5,20.3,21.4,23.9,21.8,20.3,20.7,24.3,23.4,22.3,22.7,20.7,24.7,21.4,24.5,20.8,24.3,21.4,22.8,22.8,24.6,20.5,20.6,24.8,24.6,24.8,20.8,24.1,20.3,23.4,22.7,22.2,23.4,24.0,23.9,21.0,24.6,23.0,20.4,24.8,21.7,20.4,21.2,23.6,24.9,22.3,23.0,20.9,21.5,20.2,21.7,20.7,20.5,22.8,24.5,21.3,21.6,24.4,24.6,21.5,21.4,22.7,20.8,21.7,24.7,24.5,24.0,23.1,21.1,23.8,24.9,24.0,20.7,24.8,20.3,24.0,22.8,22.4,21.4,22.0,20.3,22.1,24.4,22.0,21.8,20.1,20.6,21.1,23.8,20.5,23.1,23.0,20.2,22.4,22.2,20.6,23.1,22.6,22.2,23.6,23.2,24.1,20.6,23.2,25.0,24.1,23.6,20.3,20.1,23.0,21.8,24.5,24.7,21.9,22.4,24.0,23.6,25.0,22.8,24.9,21.9,22.6,21.4,20.2,20.8,20.6,21.0,24.0,20.8,25.0,24.4,24.9,20.2,22.6,24.6,21.3,21.8,21.4,24.2,21.8,23.8,23.8,24.6,22.3,22.1,22.9,21.7,20.2,21.9,20.4,22.7,22.4,20.3,23.2,24.2,24.2,21.8,21.9,21.5,20.8,24.0,20.4,21.2,22.4,23.5,22.2,21.7,23.3,22.3,20.5,22.2,20.9,24.7,20.7,23.2,22.6,20.2,22.9,24.3,20.9,22.6,23.8,24.2,23.4,20.3,23.0,21.7,24.2,21.3,22.6,24.4,24.8,25.0,23.6,21.8,21.9,21.1,20.9,25.0,22.4,20.4,20.2,21.9,24.9,22.6,20.0,20.4,22.4,22.3,22.8,20.7,23.2,23.2,21.4,22.5,20.9,24.0,25.0,21.4,21.0,20.7,24.5,20.6,20.2,22.6,23.2,23.2,23.4,22.7,20.6,22.0,22.7,20.6,21.4,21.5,22.9,24.0,21.3,25.0,20.7,24.6,21.0,23.2,22.9,21.9,21.4,20.9,21.7,23.5,24.2,22.9,21.3,23.0,20.7,21.8,25.0,20.9,20.7,23.3,23.1,22.0};
}
