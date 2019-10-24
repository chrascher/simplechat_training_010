package at.cgsit.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.cgsit.training.api.rest.dto.ChatMessageDto;
import at.cgsit.training.persistence.dao.ChatMessageDao;
import at.cgsit.training.persistence.entities.ChatMessageEntity;

import java.time.LocalDateTime;

import org.apache.log4j.Logger;

/**
 * @author CGS IT-Solutions
 */
@Service
public class ChatMessageService {
	   final static Logger logger = Logger.getLogger(ChatMessageService.class);

	@Autowired
	private ChatMessageDao cmDao;
	   
	/*
		1. schaue ob die chat nachricht ein command ist ? 
	    2. wenn nicht dann schreibe die messgae in die DB
	    3. wenn ja 
	     3.1. dann schaue ob es das command /go <raumname> ist
	     3.2. wenn ja dann checke, ob es diesen raum schon in der DB gibt.
	     3.3. wenn nicht dann log einen fehler in das server log das es den raum nicht gibt.
	     3.4. falls ja dann speichere die Zuordnung chat-user -> zu raum in einem Singleton bean in einer liste als hash map ab.
    */
	public void chatmessageHandler(ChatMessageDto dto) {		
		if(dto== null ) {
			logger.warn("object was null " );
			return;
		}
		
		if(dto.getChatMessage().startsWith("/go")) {
			logger.warn("this is a command" + dto.getChatMessage());
		}

		ChatMessageEntity newDbObject = this.translateFromDto(dto);
		
		cmDao.insertChatMessage(newDbObject);
		
	}
	
	
	public ChatMessageEntity translateFromDto(ChatMessageDto input) {
		
        ChatMessageEntity newObject = new ChatMessageEntity();
        newObject.setUserName(input.getUserName());
        newObject.setChatMessage(input.getChatMessage());
        newObject.setChatRoom(input.getChatRoom() != null ? input.getChatRoom() : "default");

        if(input.getCreationTime()!=null) {
            newObject.setCreationTime(input.getCreationTime());
        } else {
            newObject.setCreationTime(LocalDateTime.now());
        }
        
        return newObject;
	}

}
