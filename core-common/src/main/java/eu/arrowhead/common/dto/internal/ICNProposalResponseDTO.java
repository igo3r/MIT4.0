package eu.arrowhead.common.dto.internal;

import java.io.Serializable;
import java.util.List;

import eu.arrowhead.common.dto.shared.OrchestrationResponseDTO;
import eu.arrowhead.common.dto.shared.OrchestrationResultDTO;

public class ICNProposalResponseDTO extends OrchestrationResponseDTO implements Serializable {

	//=================================================================================================
	// members

	private static final long serialVersionUID = -206034951431082007L;

	private boolean useGateway = false;

	
	//=================================================================================================
	// methods

	//-------------------------------------------------------------------------------------------------
	public ICNProposalResponseDTO() {
		super();
	}

	//-------------------------------------------------------------------------------------------------
	public ICNProposalResponseDTO(final List<OrchestrationResultDTO> response) {
		super(response);
		
		this.useGateway = false;
	}
	
	//-------------------------------------------------------------------------------------------------
	public ICNProposalResponseDTO(final OrchestrationResultDTO result) {
		super(List.of(result));
		this.useGateway = true;
	}

	//-------------------------------------------------------------------------------------------------
	public boolean isUseGateway() { return useGateway; }

	//-------------------------------------------------------------------------------------------------
	public void setUseGateway(final boolean useGateway) { this.useGateway = useGateway; }

}