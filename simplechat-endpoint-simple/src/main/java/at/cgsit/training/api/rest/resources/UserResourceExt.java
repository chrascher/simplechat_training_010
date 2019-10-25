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

import at.cgsit.training.api.rest.dto.ChatUserDto;
import at.cgsit.training.persistence.dao.ChatUserimpleDao;
import at.cgsit.training.persistence.entities.ChatUserEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Extended User Resource
 *
 *  @Author CGS-IT Solutions @2019
 */
@Path("userext")
@Controller
public class UserResourceExt {
    final static Logger logger = LoggerFactory.getLogger(UserResourceExt.class);

	// inject the chat user data access object 
	@Autowired
	private ChatUserimpleDao chatUserDao;
	
    @GET
    @Path("useraccount/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ChatUserDto getDemoObject (@PathParam("id") String id ) {

    	logger.info("id erhalten: {}", id );
    	
    	Long userId = Long.parseLong(id);

    	ChatUserEntity userEntity = chatUserDao.findChatUser(userId);

    	ChatUserEntity user2 = chatUserDao.findChatUserBySelect(userId);
    	
    	ChatUserDto obj = new ChatUserDto();
    	obj.setUser_id( userEntity.getId().toString() );
    	obj.setUsername( userEntity.getNicname() );
    	obj.setEmail( userEntity.getEmail() );
    	
    	return obj;
    }
   
    @PUT
    @Path("useraccount")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ChatUserDto putDemoObject (ChatUserDto input, @Context final HttpServletResponse response ) {
    	
        //set HTTP code to "201 Created"
        response.setStatus(HttpServletResponse.SC_CREATED);
        
        try {
            response.flushBuffer();
        }catch(Exception e){}       
    	
    	input.setUsername(input.getUsername() +  " ext" );
    	return input;
    }
       
    
    
}
