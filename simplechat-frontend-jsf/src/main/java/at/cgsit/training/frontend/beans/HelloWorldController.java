
package at.cgsit.training.frontend.beans;


//import javax.enterprise.context.RequestScoped;

import javax.inject.Named;

import java.io.Serializable;

/**
 * simple backing bean, 
 * that is backed to <code>helloworld.jsp</code>
 */


@Named("helloWorld")
//@RequestScoped
public class HelloWorldController implements Serializable {

	private String name;
    
    /**
     * default empty constructor
     */
    public HelloWorldController(){
        this.name = "test";
    }
    
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Method that is backed to a submit button of a form.
     */
    public String send(){
        return "success";
    }
}