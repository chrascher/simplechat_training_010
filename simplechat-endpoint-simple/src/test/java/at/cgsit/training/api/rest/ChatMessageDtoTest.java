package at.cgsit.training.api.rest;

import at.cgsit.training.api.provider.CustomJacksonProvider;
import at.cgsit.training.api.rest.dto.ChatMessageDto;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

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

    private static final String REST_BASE = "http://localhost:5555/simplechat_endpoint_simple_war";

    private static final String REST_API_BASE = REST_BASE + "/api/rest";

    private static final String REST_CHAT_MESSAGE = REST_BASE + "/chat/chat-message";

    private static Client client;

    @BeforeClass
    public static void init() {
        ClientBuilder builder = ClientBuilder.newBuilder();
        builder.register(CustomJacksonProvider.of(), 100);
        client = builder.build();
    }


    @Test
    public void chatMessagePutTest() {

        ChatMessageDto newMsg = new ChatMessageDto();
        newMsg.setChatMessage("test Message via api 2");
        newMsg.setChatRoom("default");
        newMsg.setUserName("johndoe");
//        newMsg.setImportant(Boolean.FALSE);
//        newMsg.setCreationTime(LocalDateTime.now());

        Response response = client.target(REST_CHAT_MESSAGE)
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(newMsg, MediaType.APPLICATION_JSON));

        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

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
