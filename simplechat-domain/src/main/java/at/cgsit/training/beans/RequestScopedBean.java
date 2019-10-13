package at.cgsit.training.beans;

import java.text.DecimalFormat;

import javax.enterprise.context.RequestScoped;


@RequestScoped
public class RequestScopedBean {
	
	private double num;
	
	RequestScopedBean() {
		 num = Math.random();
	}
	
	public String calculate() {

	    DecimalFormat df = new DecimalFormat("###.###");
	    return df.format(num);	
	}
	

}
