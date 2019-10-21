package at.cgsit.training.api.rest.resources;

import at.cgsit.training.api.rest.dto.ChatMessage;
import at.cgsit.training.api.rest.dto.ChatMessageQueryParam;
import at.cgsit.training.api.rest.dto.UserAccount;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Path("chat")
@Dependent
public class ChatMessageResource {
    final static Logger logger = Logger.getLogger(ChatMessageResource.class);

    private static List<ChatMessage> messages = new ArrayList<>();

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

        messages.add(input);
    }

    // ChatMessageQueryParam input,
    @GET
    @Path("chat-message")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<ChatMessage> getChatMessage(@Context final HttpServletResponse response) {

        logger.info("get chat messages. current message size is:" + messages.size());

        List<ChatMessage> result = new ArrayList<>();
        messages.forEach(m -> result.add(m));

        return result;
    }

}
