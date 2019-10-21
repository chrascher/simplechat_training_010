package at.cgsit.training.beans;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import at.cgsit.training.persistence.dao.ChatUserimpleDao;


@Dependent
public class DemoBusinessBean {
	
	final static Logger logger = Logger.getLogger(DemoBusinessBean.class);
	
	@Inject
	private ChatUserimpleDao simple;
	
	public String calculate() {
		
		logger.info("DemoBusinessBean calculate 2" );
		
		simple.doSomehting();
		
		return "";
	}
	

}
