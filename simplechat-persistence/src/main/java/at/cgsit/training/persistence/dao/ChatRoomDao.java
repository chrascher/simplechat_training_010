package at.cgsit.training.persistence.dao;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import at.cgsit.training.persistence.entities.ChatMessageEntity;
import at.cgsit.training.persistence.entities.ChatRoomEntity;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Chat Room Data Access Object 
 * 
 * @author CGS IT-Solutions
 */
@Dependent
public class ChatRoomDao {
	
    @Inject
    private EntityManager em;

    /**
     * insert into DB
     * @param toInsert prepared object filled from Rest DTO values but no id
     * @return ChatRoomEntity
     */
    public ChatRoomEntity insertChatMessage(ChatRoomEntity toInsert) {
        em.getTransaction().begin();
        em.persist(toInsert);
        em.getTransaction().commit();
        return toInsert;
    }

    /**
     * find normal or temporary chat rooms
     * @param temporaryRooms
     * @return
     */
    public List<ChatRoomEntity> findChatRoom(Boolean temporaryRooms) {

        if(temporaryRooms==null) {
            temporaryRooms = Boolean.FALSE;
        }

        Query query = em.createQuery("SELECT room FROM ChatRoomEntity room WHERE room = :tempRoom");
        query.setParameter("tempRoom", temporaryRooms);
        List<ChatRoomEntity> resultList = query.getResultList();
        return resultList;
    }
}
