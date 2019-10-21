package at.cgsit.training.api.rest;

import at.cgsit.training.api.provider.CustomJacksonProvider;
import at.cgsit.training.api.rest.dto.ChatMessage;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ChatMessageTest {

    private static final String REST_URI
            = "http://localhost:8080/simplechat_endpoint_simple_war/api/rest/chat/chat-message";

    // private Client client = ClientBuilder.newClient();
    private static Client client;

    @BeforeClass
    public static void init() {

        ClientBuilder builder = ClientBuilder.newBuilder();
        builder.register(CustomJacksonProvider.of(), 100);
        client = builder.build();
    }


    @Test
    public void chatMessagePutTest() {

        ChatMessage newMsg = new ChatMessage();
        newMsg.setChatMessage("test Message 2");
        newMsg.setChatRoom("default");
        newMsg.setCreationTime(LocalDateTime.now());

        Response put = client.target(REST_URI).request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(newMsg, MediaType.APPLICATION_JSON));
    }

    @Test
    public void chatMessageGetList() {

        List<ChatMessage> result = null;

        result  =  client.target(REST_URI)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<ChatMessage>>() { });

        System.out.println("list result is: " + result.size() ) ;

    }


}
