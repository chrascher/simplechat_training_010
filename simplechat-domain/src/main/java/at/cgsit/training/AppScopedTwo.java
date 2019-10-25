/**
 * 
 */
package at.cgsit.training;

import at.cgsit.training.persistence.dao.ChatRoomDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;


/**
 * @author CGS IT-Solutions
 */
@Scope("singleton")
public class AppScopedTwo {

	final static Logger logger = LoggerFactory.getLogger(ChatRoomDao.class);

	public void ping(String message) {		
		logger.info("info message: " + message);
	}
	
}
