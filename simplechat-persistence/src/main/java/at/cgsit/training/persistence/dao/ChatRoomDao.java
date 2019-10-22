package at.cgsit.training.persistence.dao;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import at.cgsit.training.persistence.entities.ChatMessageEntity;
import at.cgsit.training.persistence.entities.ChatRoomEntity;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Chat Room Data Access Object 
 * 
 * @author CGS IT-Solutions
 */
@Dependent
public class ChatRoomDao {
    final static Logger logger = Logger.getLogger(ChatRoomDao.class);

    @Inject
    private EntityManager em;

    /**
     * insert into DB
     * @param toInsert prepared object filled from Rest DTO values but no id
     * @return ChatRoomEntity
     */
    public ChatRoomEntity insertChatRoom(ChatRoomEntity toInsert) {
        try {
            em.getTransaction().begin();
            em.persist(toInsert);
            em.getTransaction().commit();
        } finally {

        }
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

        Query query = em.createQuery("SELECT room FROM ChatRoomEntity room WHERE room.tempRoom = :tempRoom or room.tempRoom IS NULL");
        query.setParameter("tempRoom", temporaryRooms);
        List<ChatRoomEntity> resultList = query.getResultList();
        return resultList;
    }

    public Optional<ChatRoomEntity> findDefaultRoom() {
        ChatRoomEntity result = null;

        Query query = em.createQuery("SELECT room FROM ChatRoomEntity room WHERE room.defaultRoom = TRUE");
        try {
            result = (ChatRoomEntity)query.getSingleResult();
        } catch(NoResultException notFound) {
            // TODO design with your team lead where to throw exceptions and where null can be returned
            // good way may be find can also find nothing. read and get (by id) may throw exception.
            logger.info("default room not found");
        }
        return Optional.ofNullable(result);
    }
}
