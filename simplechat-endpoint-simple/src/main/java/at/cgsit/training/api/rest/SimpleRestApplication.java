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
package at.cgsit.training.api.rest;

import at.cgsit.training.api.rest.json.JacksonJavaTimeConfiguration;
import at.cgsit.training.api.rest.resources.ChatMessageResource;
import at.cgsit.training.api.rest.resources.ChatRoomResource;
import at.cgsit.training.api.rest.resources.UserResource;
import at.cgsit.training.api.rest.resources.UserResourceExt;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api/rest")
public class SimpleRestApplication extends Application {

    @Override
    public  Set<Class<?>> getClasses() {
        HashSet<Class<?>> set = new HashSet<>();

        // filters(interceptors)
        registerFilters(set);

        // Add Rest Resource Services
        set.add(UserResource.class);
        set.add(UserResourceExt.class);
        set.add(ChatMessageResource.class);
        set.add(ChatRoomResource.class);

        return set;
    }

    protected void registerFilters(HashSet<Class<?>> set) {
        // to serialize/deserialize LocalDate in Json
        set.add(JacksonJavaTimeConfiguration.class);

    }
}
