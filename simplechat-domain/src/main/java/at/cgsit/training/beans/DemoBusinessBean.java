package at.cgsit.training.beans;

import java.text.DecimalFormat;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import at.cgsit.training.persistence.SimpleUsage;


@Dependent
public class DemoBusinessBean {
	
	@Inject
	private SimpleUsage simple;
	
	public String calculate() {
		
		simple.doSomehting();
		
		return "";
	}
	

}
