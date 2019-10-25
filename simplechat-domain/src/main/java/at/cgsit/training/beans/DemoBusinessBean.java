package at.cgsit.training.beans;

import at.cgsit.training.persistence.dao.ChatUserimpleDao;
import at.cgsit.training.service.ChatMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CGS IT-Solutions
 */
@Service
public class DemoBusinessBean {
	final static Logger logger = LoggerFactory.getLogger(ChatMessageService.class);

	@Autowired
	private ChatUserimpleDao simple;
	
	public String calculate() {
		
		logger.info("DemoBusinessBean calculate 2" );

		simple.doSomehting();
		
		return "";
	}
	

}
