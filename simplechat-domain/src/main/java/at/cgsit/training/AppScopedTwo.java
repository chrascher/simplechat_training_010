/**
 * 
 */
package at.cgsit.training;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;


/**
 * @author cgssc
 *
 */
@Scope("singleton")
public class AppScopedTwo {

	final static Logger logger = Logger.getLogger(AppScopedTwo.class);

	
	public void ping(String message) {		
		logger.info("info message: " + message);
	}
	
}
