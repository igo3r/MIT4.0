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
	public static final String MIT_CONSUMER_SERVICE_TURN_ON = "turn_aircondition_on"; 
	public static final String MIT_CONSUMER_SERVICE_TURN_ON_URI = "/turn_aircondition_on"; 
	public static final String MIT_CONSUMER_SERVICE_TURN_OFF = "turn_aircondition_off"; 
	public static final String MIT_CONSUMER_SERVICE_TURN_OFF_URI = "/turn_aircondition_off"; 	
	public static final String MIT_CONSUMER_SYSTEM_NAME = "consumer";
	
	
	/* --- Producer Constants --- */
	public static final String PROPERTY_C2_ADDRESS = "c2_address";
	public static final String PROPERTY_C2_PATH = "c2_path";
	public static final String PROPERTY_C2_PORT = "c2_port";
	public static final String MIT_SYSTEM_PRODUCER = "Producer";
	public static final String MIT_PRODUCER_URI = "/producer";
	public static final String MIT_PRODUCER_SERVICE_GET_TEMPERATURE = "get_temperature";
	public static final String MIT_PRODUCER_GET_TEMPERATURE_URI = "/get_temperature";
	public static final String MIT_PRODUCER_SYSTEM_NAME = "producer";
	
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
	public static final int MIT_DEFAULT_CLIENT_PORT = 2249;
	public static final String PARAMETER_ID = "id";
	}
