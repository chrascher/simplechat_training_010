package at.cgsit.training.api.rest.provider;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.Provider;

@Provider
@Consumes({ "application/json","application/*+json", "text/json" })
@Produces({ "application/json","application/*+json", "text/json" })
public class JsonProvider extends JacksonJsonProvider {
}
