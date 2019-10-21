package at.cgsit.training.api.rest.resources;

import at.cgsit.training.api.rest.dto.ChatMessage;
import at.cgsit.training.api.rest.dto.ChatMessageQueryParam;
import at.cgsit.training.api.rest.dto.UserAccount;
import at.cgsit.training.persistence.dao.ChatMessageDao;
import at.cgsit.training.persistence.entities.ChatMessageEntity;
import org.apache.log4j.Logger;
import org.hsqldb.lib.StringUtil;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Path("chat")
@Dependent
public class ChatMessageResource {
    final static Logger logger = Logger.getLogger(ChatMessageResource.class);

    private static List<ChatMessage> messages = new ArrayList<>();

    @Inject
    ChatMessageDao dao;


    @PostConstruct
    public void init() {
        // add a starting dummy message
        ChatMessage newMsg = new ChatMessage();
        newMsg.setChatMessage("test Message dummy");
        newMsg.setChatRoom("default");
        newMsg.setCreationTime(LocalDateTime.now());
        messages.add(newMsg);
    }

    @PUT
    @Path("chat-message")
    //@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void sendChatMessage(ChatMessage input, @Context final HttpServletResponse response) {
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


        messages.add(input);
    }

    // ChatMessageQueryParam input,
    @GET
    @Path("chat-message")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<ChatMessage> getChatMessage(@QueryParam(value="newerthen") String newerThen) {
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

        List<ChatMessage> result = new ArrayList<>();

        dbResultList.forEach(dbObject -> {
            ChatMessage msg = new ChatMessage();
            msg.setUserName(dbObject.getUserName());
            msg.setCreationTime(dbObject.getCreationTime());
            msg.setChatRoom(dbObject.getChatRoom());
            msg.setChatMessage(dbObject.getChatMessage());
            result.add(msg);
        });

        return result;
    }

}
