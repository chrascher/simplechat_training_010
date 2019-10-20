/*
 * (C) Copyright 22019 CGS IT-Solutions (http://www.cgs.at/).
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

import at.cgsit.training.ApplicationInformation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * User resource is a minimal example howto use jax-rs rest services
 * without any further dependencies.
 * <br/>
 * it produces the resulting json as manually provided hardcoded string.
 *
 * @Author CGS-IT Solutions @2019
 * @Version 1.1.0
 */
@Path("user")
public class UserResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String message() {
        return "{ \"result\" : \" Hello World \" }";
    }	
	
    
    
}
