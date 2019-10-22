package at.cgsit.training.api.rest.resources;

import at.cgsit.training.api.rest.dto.ChatRoomDto;
import at.cgsit.training.persistence.dao.ChatRoomDao;
import at.cgsit.training.persistence.entities.ChatRoomEntity;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("room")
@Dependent
public class ChatRoomResource {
    final static Logger logger = Logger.getLogger(ChatRoomResource.class);

    @Inject
    ChatRoomDao dao;

    @PostConstruct
    public void init() {
        Optional<ChatRoomEntity> opResult = dao.findDefaultRoom();
        if(opResult.isEmpty()) {
            ChatRoomEntity dbObject = new ChatRoomEntity();
            dbObject.setRoomName("default");
            dbObject.setDefaultRoom(Boolean.TRUE);
            dbObject.setMaxUsers(1000);
            dbObject.setTempRoom(Boolean.FALSE);
            ChatRoomEntity newDefault = dao.insertChatRoom(dbObject);

            logger.info("new default room :" + newDefault.getId());
        }
    }

    @PUT
    // @Path("rooms")
    //@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertChatRoom(ChatRoomDto input) {

        ChatRoomEntity dbObject = new ChatRoomEntity();
        dbObject.setRoomName(input.getRoomName());
        dbObject.setDefaultRoom(input.getDefaultRoom());
        dbObject.setMaxUsers(input.getMaxUsers());
        dbObject.setTempRoom(input.getTempRoom());

        ChatRoomEntity chatRoomEntity = dao.insertChatRoom(dbObject);

        logger.info("getChatMessage" + chatRoomEntity.getId() );
    }

    @GET
    // @Path("rooms")
    @Produces(MediaType.APPLICATION_JSON)
    // @Consumes(MediaType.APPLICATION_JSON)
    public List<ChatRoomDto> getChatRooms(@QueryParam(value="get-temp-rooms" ) Boolean temporaryRooms) {
        logger.info("getChatMessage");

        List<ChatRoomEntity> chatRooms = dao.findChatRoom(Boolean.FALSE);

        List<ChatRoomDto> result = new ArrayList<>(10);

        chatRooms.forEach( entity -> {
            ChatRoomDto resultDto = new ChatRoomDto();
            resultDto.setRoomName( entity.getRoomName());
            resultDto.setDefaultRoom( entity.getDefaultRoom());
            resultDto.setTempRoom(entity.getTempRoom());
            resultDto.setMaxUsers( entity.getMaxUsers());
            result.add(resultDto);
        });
        logger.info("getChatMessage returns number of rooms: " + result.size());
        return result;
    }


}