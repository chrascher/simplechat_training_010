package at.cgsit.training.persistence;

import at.cgsit.training.persistence.dao.ChatUserDao;
import at.cgsit.training.persistence.entities.ChatUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class ChatUserImplDao {

    // @Autowired
    // @PersistenceContext
    // private EntityManager em;
	
	// @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ChatUser doSomehting() {

        // em.getTransaction().begin();
		
	    ChatUser cu = new ChatUser();
        cu.setNicname("testnic");
        cu.setEmail("testnic@cgs.at");

        // em.persist(cu);
        
        // em.getTransaction().commit();
        
        return cu;
    }

    public List<ChatUser> findAll() {
        // Query query = em.createQuery("SELECT user FROM ChatUser user");
        return null; // query.getResultList();
    }

    /**
     * find user by ID 
     * @param userId
     */
	public ChatUser findChatUser(Long userId) {
         
         ChatUser result = null ; // em.find(ChatUser.class, userId);
         if (result == null) {
			throw new RuntimeException("ChatUser account nicht gefunden");
  		 }    
	     return result;
	 }

	public ChatUser findChatUserBySelect(Long userId) {
        
        Query query = null; // em.createQuery("SELECT user FROM ChatUser user WHERE user.id = :userid");
        query.setParameter("userid", userId);
        
        ChatUser result = (ChatUser) query.getSingleResult();
        
	     return result;
	}
}