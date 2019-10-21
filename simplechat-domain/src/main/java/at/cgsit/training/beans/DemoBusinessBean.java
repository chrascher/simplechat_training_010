package at.cgsit.training.beans;

import at.cgsit.training.persistence.ChatUserImplDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


public class DemoBusinessBean {
	
	final static Logger logger = Logger.getLogger(DemoBusinessBean.class);

	@Autowired
	private ChatUserImplDao simple;
	
	public String calculate() {
		
		logger.info("DemoBusinessBean calculate 2" );

		simple.doSomehting();
		
		return "";
	}
	

}
