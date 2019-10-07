package at.cgsit.training;

import javax.enterprise.context.ApplicationScoped;

// TODO CDI Container config for tomcat 9.0s
@ApplicationScoped
public class ApplicationInformation {

    public String helloWorld() {
        return "Hello World";
    }

}
