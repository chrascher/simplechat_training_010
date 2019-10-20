package at.cgsit.training.beans;

import org.apache.log4j.Logger;

import at.cgsit.training.persistence.ChatUserImplDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


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
