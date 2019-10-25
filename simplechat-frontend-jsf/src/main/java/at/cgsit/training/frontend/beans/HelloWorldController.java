
package at.cgsit.training.frontend.beans;


import org.apache.log4j.Logger;

import java.io.Serializable;

/**
 * simple backing bean, 
 * that is backed to <code>helloworld.jsp</code>
 */


// @Named("helloWorld")
//@RequestScoped
public class HelloWorldController implements Serializable {
    final static Logger logger = Logger.getLogger(HelloWorldController.class);


	private String name;

	private String vorname;

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

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    /**
     * Method that is backed to a submit button of a form.
     */
    public String send(){
        logger.info("send was called: " + this.getName() );

        if(this.getName()!=null && ! this.getName().isBlank() ) {
            String[] splited = getName().split("\\s+");
            this.name = splited[0];
            this.vorname = splited[1];
        }
        return "success";
    }
}