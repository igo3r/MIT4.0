package eu.arrowhead.mit.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import eu.arrowhead.common.CommonConstants;
import eu.arrowhead.common.mit.MITConstants;
import eu.arrowhead.common.swagger.DefaultSwaggerConfig;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class AuthSwaggerConfig extends DefaultSwaggerConfig {
	
	//=================================================================================================
	// methods

	//-------------------------------------------------------------------------------------------------
	
	public AuthSwaggerConfig() {
		super(MITConstants.MIT_SYSTEM_CLIENT);
	}
	
	//-------------------------------------------------------------------------------------------------
	@Bean
	public Docket customizeSwagger() {
		return configureSwaggerForCoreSystem(this.getClass().getPackageName());
	}
}
