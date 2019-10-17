package at.cgsit.training.api.rest.resources;

import at.cgsit.training.AppScopedTwo;
import at.cgsit.training.ApplicationInformation;
import at.cgsit.training.api.rest.dto.UserAccount;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

@Path("userext")
@Dependent
public class UserResourceExt {

	final static Logger logger = Logger.getLogger(UserResourceExt.class);
	
	
    @GET
    @Path("useraccount/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserAccount getDemoObject ( @PathParam("id") String id ) {   
    	
    	logger.info("id erhalten: " + id );
    	
    	if( !"1".equalsIgnoreCase(id) ) {
    		throw new RuntimeException("Ein Fehler ist aufgetreten");
    	}
    	// database.find(id);
    	
    	UserAccount obj = new UserAccount();
    	obj.setUser_id("1");
    	obj.setUsername("my nick name" );
    	obj.setEmail( "john@cgs.at");
    	return obj;
    }
   
    @PUT
    @Path("useraccount")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public UserAccount putDemoObject (UserAccount input, @Context final HttpServletResponse response ) {   
    	
        //set HTTP code to "201 Created"
        response.setStatus(HttpServletResponse.SC_CREATED);
        
        try {
            response.flushBuffer();
        }catch(Exception e){}       
    	
    	input.setUsername(input.getUsername() +  " ext" );
    	return input;
    }
       
    
    
}



//     @Path("gettestobject")