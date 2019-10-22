package at.cgsit.training.persistence.dao;

import at.cgsit.training.persistence.entities.ChatUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ChatUserimpleDao {

    @Autowired
    private EntityManager em;

    // @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ChatUserEntity doSomehting() {

        em.getTransaction().begin();

        ChatUserEntity cu = new ChatUserEntity();
        cu.setNicname("testnic");
        cu.setEmail("testnic@cgs.at");

        em.persist(cu);

        em.getTransaction().commit();

        return cu;
    }

    public List<ChatUserEntity> findAll() {
        Query query = em.createQuery("SELECT user FROM ChatUserEntity user");
        return query.getResultList();
    }

    /**
     * find user by ID
     *
     * @param userId
     */
    public ChatUserEntity findChatUser(Long userId) {

        ChatUserEntity result = em.find(ChatUserEntity.class, userId);
        if (result == null) {
            throw new RuntimeException("ChatUser account nicht gefunden");
        }
        return result;
    }

    public ChatUserEntity findChatUserBySelect(Long userId) {

        Query query = em.createQuery("SELECT user FROM ChatUserEntity user WHERE user.id = :userid");
        query.setParameter("userid", userId);
        ChatUserEntity result = (ChatUserEntity) query.getSingleResult();
        return result;
    }
}
