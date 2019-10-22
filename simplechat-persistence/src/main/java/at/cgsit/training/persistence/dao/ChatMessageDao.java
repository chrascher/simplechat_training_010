package at.cgsit.training.persistence.dao;

import at.cgsit.training.persistence.entities.ChatMessageEntity;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

/**
 * chat messages DAO
 */
@Dependent
public class ChatMessageDao {

    @Inject
    private EntityManager em;

    /**
     * insert into DB
     * @param toInsert prepared object filled from Rest DTO values but no id
     * @return
     */
    public ChatMessageEntity insertChatMessage(ChatMessageEntity toInsert) {
        em.getTransaction().begin();
        em.persist(toInsert);
        em.getTransaction().commit();
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
