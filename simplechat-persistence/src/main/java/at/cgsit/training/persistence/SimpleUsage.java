package at.cgsit.training.persistence;

import at.cgsit.training.persistence.dao.ChatUserDao;
import at.cgsit.training.persistence.entities.ChatUser;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Dependent
public class SimpleUsage {

	@Inject
    private EntityManager entityManager;
	
    public List<ChatUser> doSomehting() {

/*        EntityManagerFactory emfactory = Persistence.
                createEntityManagerFactory( "PU_TEST" );
        EntityManager entitymanager = emfactory.createEntityManager( );
*/

        ChatUserDao dao = new ChatUserDao();
        dao.setEntityManager(entityManager);

        List<ChatUser> all = dao.getAll();

        return all;
    }



}
