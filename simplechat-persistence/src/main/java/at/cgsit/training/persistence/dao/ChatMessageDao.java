package at.cgsit.training.persistence.dao;

import at.cgsit.training.persistence.entities.ChatMessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

/**
 * chat messages DAO
 */
@Repository
public class ChatMessageDao {

    @Autowired
    private EntityManager em;

    /**
     * insert into DB
     * @param toInsert prepared object filled from Rest DTO values but no id
     * @return
     */
    @Transactional
    public ChatMessageEntity insertChatMessage(ChatMessageEntity toInsert) {
        em.persist(toInsert);
        return toInsert;
    }

    public List<ChatMessageEntity> findChatMessageNewerThen(LocalDateTime newerThen) {
        if(newerThen==null)
            throw new NullPointerException("find without date is not allowed!");

        Query query = em.createQuery("SELECT chatmsg FROM ChatMessageEntity chatmsg WHERE chatmsg.creationTime >= :createTimeParam");
        query.setParameter("createTimeParam", newerThen);
        List<ChatMessageEntity> resultList = query.getResultList();
        return resultList;
    }

}
