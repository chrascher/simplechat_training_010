package at.cgsit.training.api.rest.dto;

import java.time.LocalDateTime;

public class ChatMessageQueryParam {

    private String chatRoom;

    private LocalDateTime creationTime;
    

    public String getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(String chatRoom) {
        this.chatRoom = chatRoom;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
}
