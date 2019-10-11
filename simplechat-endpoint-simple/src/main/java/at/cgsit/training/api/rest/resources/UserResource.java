package at.cgsit.training.api.rest.resources;

import at.cgsit.training.ApplicationInformation;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("user")
@Dependent
public class UserResource {

    @Inject
    private ApplicationInformation applicationInformation;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String message() {
        return "{ \"result\" : \"" + applicationInformation.helloWorld() + "\" }";
    }

}
