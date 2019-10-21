package at.cgsit.training.persistence.dao;

import at.cgsit.training.persistence.entities.ChatUser;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Dependent
public class ChatUserimpleDao {

    @Inject
    private EntityManager em;

    // @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ChatUser doSomehting() {

        em.getTransaction().begin();

        ChatUser cu = new ChatUser();
        cu.setNicname("testnic");
        cu.setEmail("testnic@cgs.at");

        em.persist(cu);

        em.getTransaction().commit();

        return cu;
    }

    public List<ChatUser> findAll() {
        Query query = em.createQuery("SELECT user FROM ChatUser user");
        return query.getResultList();
    }

    /**
     * find user by ID
     *
     * @param userId
     */
    public ChatUser findChatUser(Long userId) {

        ChatUser result = em.find(ChatUser.class, userId);
        if (result == null) {
            throw new RuntimeException("ChatUser account nicht gefunden");
        }
        return result;
    }

    public ChatUser findChatUserBySelect(Long userId) {

        Query query = em.createQuery("SELECT user FROM ChatUser user WHERE user.id = :userid");
        query.setParameter("userid", userId);
        ChatUser result = (ChatUser) query.getSingleResult();
        return result;
    }
}
