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


import at.cgsit.training.api.rest.resources.UserResource;
import at.cgsit.training.api.rest.resources.UserResourceExt;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class SimpleRestApplication extends Application {

    public SimpleRestApplication() {

    }

    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(UserResource.class);
        classes.add(UserResourceExt.class);
        return classes;
    }

}
