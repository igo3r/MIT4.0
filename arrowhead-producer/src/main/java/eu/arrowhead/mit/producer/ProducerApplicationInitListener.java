package eu.arrowhead.mit.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import eu.arrowhead.common.ApplicationInitListener;
import eu.arrowhead.common.database.service.CommonDBService;

@Component
public class ProducerApplicationInitListener extends ApplicationInitListener {

	// =================================================================================================
	// members

	@Autowired
	private CommonDBService commonDBService;

	// uncomment this line if there is a problem with "unregister service" -
	// ATTENTION THIS IS JUST A WORKAROUND
	// this line means, the system will be not registered
//	public void onApplicationEvent(final ContextRefreshedEvent event) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, InterruptedException {}

}
