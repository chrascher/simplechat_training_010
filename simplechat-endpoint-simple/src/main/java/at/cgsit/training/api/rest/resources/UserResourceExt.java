/*
 * (C) Copyright 2019 CGS IT-Solutions (http://www.cgs.at/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package at.cgsit.training.api.rest.resources;

import at.cgsit.training.api.rest.dto.UserAccount;
import at.cgsit.training.persistence.dao.ChatUserimpleDao;
import at.cgsit.training.persistence.entities.ChatUser;

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

/**
 * Extended User Resource
 *
 *  @Author CGS-IT Solutions @2019
 */
@Path("userext")
@Dependent
public class UserResourceExt {

	final static Logger logger = Logger.getLogger(UserResourceExt.class);
	
	// inject the chat user data access object 
	@Inject
	private ChatUserimpleDao chatUserDao;
	
    @GET
    @Path("useraccount/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserAccount getDemoObject ( @PathParam("id") String id ) {   

    	logger.info("id erhalten: " + id );
    	
    	Long userId = Long.parseLong(id);

    	ChatUser userEntity = chatUserDao.findChatUser(userId);
    	
    	ChatUser user2 = chatUserDao.findChatUserBySelect(userId);
    	
    	UserAccount obj = new UserAccount();
    	obj.setUser_id( userEntity.getId().toString() );
    	obj.setUsername( userEntity.getNicname() );
    	obj.setEmail( userEntity.getEmail() );
    	
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