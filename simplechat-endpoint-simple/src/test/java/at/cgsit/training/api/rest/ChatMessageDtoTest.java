package at.cgsit.training.api.rest;

import at.cgsit.training.api.provider.CustomJacksonProvider;
import at.cgsit.training.api.rest.dto.ChatMessageDto;
import at.cgsit.training.api.rest.resources.ChatRoomResource;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.List;

@Ignore
public class ChatMessageDtoTest {
    final static Logger logger = LoggerFactory.getLogger(ChatMessageDtoTest.class);

    // http://localhost:8080/simplechat_endpoint_simple_war/api/rest/chat/chat-message

    private static String REST_WEBAPP_NAME = "/simplechat_endpoint_simple_war";

    private static final String REST_BASE = "http://localhost:8080" + REST_WEBAPP_NAME;

    private static final String REST_API_BASE = REST_BASE + "/api/rest";

    private static final String REST_CHAT_MESSAGE = REST_API_BASE + "/chat/chat-message";

    private static Client client;

    @BeforeClass
    public static void init() {
        ClientBuilder builder = ClientBuilder.newBuilder();
        // builder.register(new JSR310Module());
        builder.register(new JavaTimeModule());
        builder.register(CustomJacksonProvider.of(), 100);
        client = builder.build();

        logger.info("using server url: {} " , REST_CHAT_MESSAGE);
    }


    // @Ignore
    @Test
    public void chatMessagePutTest() {

        ChatMessageDto newMsg = new ChatMessageDto();
        newMsg.setChatMessage("test Message via api 2");
        newMsg.setChatRoom("default");
        newMsg.setUserName("johndoe");
//        newMsg.setImportant(Boolean.FALSE);
//        newMsg.setCreationTime(LocalDateTime.now());

        // .request(MediaType.APPLICATION_JSON)
        Response response = client.target(REST_CHAT_MESSAGE)
                .request()
                .put(Entity.entity(newMsg, MediaType.APPLICATION_JSON));

        Assert.assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());

    }

    /**
     * ?newerthen=2019-10-01%2011%3A30%3A00
     */
    @Test
    public void chatMessageGetList() {

        List<ChatMessageDto> result = null;

        Response response =  client.target(REST_CHAT_MESSAGE)
                .request(MediaType.APPLICATION_JSON)
                .get();

        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

        result = response.readEntity( new GenericType<List<ChatMessageDto>>() {});

        // Assert.assertEquals(Response.Status.OK, response.getStatus());

        System.out.println("list result is: " + result.size() ) ;

    }


}
