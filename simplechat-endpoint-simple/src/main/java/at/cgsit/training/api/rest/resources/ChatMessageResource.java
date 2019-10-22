package at.cgsit.training.api.rest.resources;

import at.cgsit.training.api.rest.dto.ChatMessageDto;
import at.cgsit.training.persistence.dao.ChatMessageDao;
import at.cgsit.training.persistence.entities.ChatMessageEntity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Path("chat")
@Controller
public class ChatMessageResource {
    final static Logger logger = Logger.getLogger(ChatMessageResource.class);

    private static List<ChatMessageDto> messages = new ArrayList<>();

    @Autowired
    ChatMessageDao dao;

    @PostConstruct
    public void init() {
        // add a starting dummy message
        ChatMessageDto newMsg = new ChatMessageDto();
        newMsg.setChatMessage("Initial Message dummy");
        newMsg.setChatRoom("default");
        newMsg.setCreationTime(LocalDateTime.now());
        messages.add(newMsg);
    }

    @PUT
    @Path("chat-message")
    //@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void sendChatMessage(ChatMessageDto input, @Context final HttpServletResponse response) {
        logger.info("sendChatMessages chat messages. adding message from user: " + input.getUserName());

        ChatMessageEntity newObject = new ChatMessageEntity();
        newObject.setUserName(input.getUserName());
        newObject.setChatMessage(input.getChatMessage());
        newObject.setChatRoom(input.getChatRoom() != null ? input.getChatRoom() : "default");

        if(input.getCreationTime()!=null) {
            newObject.setCreationTime(input.getCreationTime());
        } else {
            newObject.setCreationTime(LocalDateTime.now());
        }

        dao.insertChatMessage(newObject);

        //set HTTP code to "201 Created"
        response.setStatus(HttpServletResponse.SC_CREATED);

        messages.add(input);
    }

    @GET
    @Path("chat-message")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<ChatMessageDto> getChatMessage(@QueryParam(value="newerthen") String newerThen) {
        logger.info("get chat messages. current message size is:" + messages.size());

        logger.info("input value for newerthen is: " +  newerThen);
        String searchTime = newerThen;

        if(searchTime == null || searchTime.isBlank()) {
            logger.info("newerThen is null setting default query timestamp");
            searchTime = "2019-01-01 11:30:00";
        }

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(searchTime, formatter1);
        logger.info("newerThen parameter parsed to: " + dateTime.toString());

        List<ChatMessageEntity> dbResultList = dao.findChatMessageNewerThen(dateTime);

        List<ChatMessageDto> result = new ArrayList<>();

        dbResultList.forEach(dbObject -> {
            ChatMessageDto msg = new ChatMessageDto();
            msg.setUserName(dbObject.getUserName());
            msg.setCreationTime(dbObject.getCreationTime());
            msg.setChatRoom(dbObject.getChatRoom());
            msg.setChatMessage(dbObject.getChatMessage());
            result.add(msg);
        });

        return result;
    }

}
