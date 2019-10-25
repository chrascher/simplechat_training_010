/*
 *
 *  * (C) Copyright 2019 CGS IT-Solutions (http://www.cgs.at/).
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *  *
 *
 *
 */

package at.cgsit.training.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChatMessageCacheTest {

    final static String USER_NAME = "john";
    final static String DEFAULT_ROOM = "default";

    private ChatMessageCache cache;

    @Before
    public void initBeforeTest() {
        cache = new ChatMessageCache();
    }

    @Test
    public void test_Add_user() {
        cache.addUserCacheMapping(USER_NAME,DEFAULT_ROOM);
        String roomNameFound = cache.getRoomForUser(USER_NAME);
        Assert.assertEquals(DEFAULT_ROOM, roomNameFound );
    }

}
