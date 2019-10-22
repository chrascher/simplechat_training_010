package at.cgsit.training.beans;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
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
