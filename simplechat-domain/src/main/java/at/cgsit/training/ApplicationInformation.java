package at.cgsit.training;

import org.springframework.context.annotation.Scope;

/**
 * @author CGS IT-Solutions
 */
@Scope("singleton")
public class ApplicationInformation {

    public String helloWorld() {
        return "Hello World";
    }

}
