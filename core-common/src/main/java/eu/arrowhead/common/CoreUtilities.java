package eu.arrowhead.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Sort.Direction;

import eu.arrowhead.common.exception.BadPayloadException;

public class CoreUtilities {
	
	//=================================================================================================
	// members
	
	private static final Logger logger = LogManager.getLogger(CoreUtilities.class);
	
	//=================================================================================================
	// methods
	
	//-------------------------------------------------------------------------------------------------
	public static Direction calculateDirection(final String direction, final String origin) {
		logger.debug("calculateDirection started ...");
		final String directionStr = direction != null ? direction.toUpperCase().trim() : "";
		Direction validatedDirection;
		switch (directionStr) {
			case CoreCommonConstants.SORT_ORDER_ASCENDING:
				validatedDirection = Direction.ASC;
				break;
			case CoreCommonConstants.SORT_ORDER_DESCENDING:
				validatedDirection = Direction.DESC;
				break;
			default:
				throw new BadPayloadException("Invalid sort direction flag", org.apache.http.HttpStatus.SC_BAD_REQUEST, origin);
		}
		
		return validatedDirection;
	}
	
	//-------------------------------------------------------------------------------------------------
	public static ValidatedPageParams validatePageParameters(final Integer page, final Integer size, final String direction, final String origin) {
		int validatedPage;
		int validatedSize;

		if (page == null && size == null) {
			validatedPage = -1;
			validatedSize = -1;
		} else {
			if (page == null || size == null) {
				throw new BadPayloadException("Defined page or size could not be with undefined size or page.", org.apache.http.HttpStatus.SC_BAD_REQUEST, origin);
			} else {
				validatedPage = page;
				validatedSize = size;
			}
		}

		final Direction validatedDirection = calculateDirection(direction, origin);
		
		return new ValidatedPageParams(validatedPage, validatedSize, validatedDirection);
	}

	//=================================================================================================
	// assistant methods

	//-------------------------------------------------------------------------------------------------
	private CoreUtilities() {
		throw new UnsupportedOperationException();
	}
	
	//=================================================================================================
	// nested classed
	
	//-------------------------------------------------------------------------------------------------
	public static class ValidatedPageParams {
		
		//=================================================================================================
		// members
		
		private final int validatedPage;
		private final int validatedSize;
		private final Direction validatedDirecion;
		
		//=================================================================================================
		// methods
		
		//-------------------------------------------------------------------------------------------------
		public ValidatedPageParams(final int validatedPage, final int validatedSize, final Direction validatedDirection) {
			this.validatedPage = validatedPage;
			this.validatedSize = validatedSize;
			this.validatedDirecion = validatedDirection;
		}

		//-------------------------------------------------------------------------------------------------
		public int getValidatedPage() { return validatedPage; }
		public int getValidatedSize() { return validatedSize; }
		public Direction getValidatedDirecion() { return validatedDirecion; } 
	}
}