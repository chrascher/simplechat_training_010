/**
 * 
 */
package at.cgsit.training;

import javax.enterprise.context.ApplicationScoped;
import org.apache.log4j.Logger;


/**
 * @author cgssc
 *
 */
@ApplicationScoped
public class AppScopedTwo {

	final static Logger logger = Logger.getLogger(AppScopedTwo.class);
	
	
	public void ping(String message) {		
		logger.info("info message: " + message);
	}
	
}
