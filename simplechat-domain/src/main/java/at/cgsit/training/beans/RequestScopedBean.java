package at.cgsit.training.beans;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

/**
 * @author CGS IT-Solutions
 */
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
