package at.cgsit.training.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import at.cgsit.training.api.rest.dto.ChatMessageDto;
import at.cgsit.training.persistence.dao.ChatMessageDao;


@RunWith(MockitoJUnitRunner.class)
public class ChatMessageServiceTest {
	
    
    @Mock
	private ChatMessageDao cmDao;

    @InjectMocks
    ChatMessageService cmService = new ChatMessageService();
    
	@Before
	public void setUp() throws Exception {		
	    MockitoAnnotations.initMocks(this);
 
	}

	@Test
	public void testChatmessageHandler_NormalMessage() {
		
		ChatMessageDto dtoInput = new ChatMessageDto();
		dtoInput.setChatMessage("general" );
		dtoInput.setChatRoom("default");
		dtoInput.setUserName("christian" );
				
		cmService.chatmessageHandler(dtoInput);		
		
		Mockito.verify(cmDao, times(1)).insertChatMessage(any());
	}
	
	 
	
	@Test
	public void testChatmessageHandler() {
		
		ChatMessageDto dtoInput = new ChatMessageDto();
		dtoInput.setChatMessage("/go general" );
		dtoInput.setChatRoom("default");
		dtoInput.setUserName("christian" );
				
		cmService.chatmessageHandler(dtoInput);		
	}
	

}

