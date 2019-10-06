package at.cgsit.training.persistence;

import at.cgsit.training.persistence.dao.ChatUserDao;
import at.cgsit.training.persistence.entities.ChatUser;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class SimpleUsage {

    public List<ChatUser> doSomehting() {

        EntityManagerFactory emfactory = Persistence.
                createEntityManagerFactory( "PU_TEST" );

        EntityManager entitymanager = emfactory.createEntityManager( );

        ChatUserDao dao = new ChatUserDao();
        dao.setEntityManager(entitymanager);

        List<ChatUser> all = dao.getAll();

        return all;
    }



}
