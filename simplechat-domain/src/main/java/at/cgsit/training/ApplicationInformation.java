package at.cgsit.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@Scope("singleton")
public class ApplicationInformation {

    public String helloWorld() {
        return "Hello World";
    }

}
