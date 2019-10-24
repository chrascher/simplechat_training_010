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
package at.cgsit.training.api.rest.dto;


import java.io.Serializable;

/**
 * @Author CGS-IT Solutions @2019
 */
public class ChatRoomDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    private String roomName;

    private int maxUsers;

    private Boolean defaultRoom;

    private Boolean tempRoom;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(int maxUsers) {
        this.maxUsers = maxUsers;
    }

    public Boolean getDefaultRoom() {
        return defaultRoom;
    }

    public void setDefaultRoom(Boolean defaultRoom) {
        this.defaultRoom = defaultRoom;
    }

    public Boolean getTempRoom() {
        return tempRoom;
    }

    public void setTempRoom(Boolean tempRoom) {
        this.tempRoom = tempRoom;
    }
}
