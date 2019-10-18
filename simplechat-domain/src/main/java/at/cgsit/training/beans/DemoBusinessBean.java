package at.cgsit.training.beans;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import at.cgsit.training.persistence.ChatUserimpleDao;


@Dependent
public class DemoBusinessBean {
	
	@Inject
	private ChatUserimpleDao simple;
	
	public String calculate() {
		
		simple.doSomehting();
		
		return "";
	}
	

}
