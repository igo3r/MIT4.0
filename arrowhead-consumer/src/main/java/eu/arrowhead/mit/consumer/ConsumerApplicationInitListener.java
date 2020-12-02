package eu.arrowhead.mit.consumer;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import eu.arrowhead.common.ApplicationInitListener;
import eu.arrowhead.common.CommonConstants;
import eu.arrowhead.common.CoreDefaults;
import eu.arrowhead.common.database.service.CommonDBService;
import eu.arrowhead.common.exception.DataNotFoundException;

@Component
public class ConsumerApplicationInitListener extends ApplicationInitListener{

	//=================================================================================================
	// members
	
	@Autowired
	private CommonDBService commonDBService; 

}
