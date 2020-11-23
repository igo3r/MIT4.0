package eu.arrowhead.common.core;

import org.springframework.util.Assert;

import eu.arrowhead.common.CommonConstants;
import eu.arrowhead.common.Utilities;
import eu.arrowhead.common.mit.MITConstants;

public enum CoreSystemService {

	//=================================================================================================
	// elements
	
	// Authorization services
	AUTH_CONTROL_INTRA_SERVICE(CommonConstants.CORE_SERVICE_AUTH_CONTROL_INTRA, CommonConstants.AUTHORIZATION_URI + CommonConstants.OP_AUTH_INTRA_CHECK_URI),
	AUTH_TOKEN_GENERATION_SERVICE(CommonConstants.CORE_SERVICE_AUTH_TOKEN_GENERATION, CommonConstants.AUTHORIZATION_URI + CommonConstants.OP_AUTH_TOKEN_URI),
	AUTH_PUBLIC_KEY_SERVICE(CommonConstants.CORE_SERVICE_AUTH_PUBLIC_KEY, CommonConstants.AUTHORIZATION_URI + CommonConstants.OP_AUTH_KEY_URI),
	AUTH_CONTROL_SUBSCRIPTION_SERVICE(CommonConstants.CORE_SERVICE_AUTH_CONTROL_SUBSCRIPTION, CommonConstants.AUTHORIZATION_URI + CommonConstants.OP_AUTH_SUBSCRIPTION_CHECK_URI),
	
	// Orchestrator services
	ORCHESTRATION_SERVICE(CommonConstants.CORE_SERVICE_ORCH_PROCESS, CommonConstants.ORCHESTRATOR_URI + CommonConstants.OP_ORCH_PROCESS),
	
	CONSUMER_CLTC_ARRAY_SINGLE_SERVICE(MITConstants.MIT_SERVICE_CLTC_ARRAY_SINGLE, MITConstants.MIT_CONSUMER_URI + MITConstants.MIT_CONSUMER_CLTC_ARRAY_SINGLE_URI),
	PRODUCER_GET_ARRAY_SERVICE(MITConstants.MIT_PRODUCER_SERVICE_GET_ARRAY, MITConstants.MIT_PRODUCER_URI + MITConstants.MIT_PRODUCER_GET_ARRAY_URI_CONNECTION);
	
	
	//=================================================================================================
	// members
	
	private final String serviceDefinition;
	private final String serviceUri;
	
	//=================================================================================================
	// methods
	
	//-------------------------------------------------------------------------------------------------
	public String getServiceDefinition() { return serviceDefinition; }
	public String getServiceUri() { return serviceUri; }
	
	
	//=================================================================================================
	// assistant methods

	//-------------------------------------------------------------------------------------------------
	private CoreSystemService(final String serviceDefinition, final String serviceUri) {
		Assert.isTrue(!Utilities.isEmpty(serviceDefinition), serviceUri);
		
		this.serviceDefinition = serviceDefinition;
		this.serviceUri = serviceUri;
	}
}
