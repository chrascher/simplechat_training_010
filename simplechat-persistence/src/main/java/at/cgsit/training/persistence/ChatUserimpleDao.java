package at.cgsit.training.persistence;

import at.cgsit.training.persistence.dao.ChatUserDao;
import at.cgsit.training.persistence.entities.ChatUser;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Dependent
public class ChatUserimpleDao {

    @Inject
    private EntityManager em;
	
	@Transactional(Transactional.TxType.REQUIRES_NEW)
    public ChatUser doSomehting() {

	    ChatUser cu = new ChatUser();
        cu.setNicname("testnic");
        cu.setEmail("testnic@cgs.at");

        em.persist(cu);
        return cu;
    }

    public List<ChatUser> findAll() {
        Query query = em.createQuery("SELECT userFROM ChatUser user");
        return query.getResultList();
    }

}
