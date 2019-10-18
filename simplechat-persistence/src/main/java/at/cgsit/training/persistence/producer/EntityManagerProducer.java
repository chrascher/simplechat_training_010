package at.cgsit.training.persistence.producer;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {

    private static EntityManagerFactory emf;

    @PostConstruct
    public void initHibernate() {
        this.emf = Persistence.createEntityManagerFactory("chatsPU");
    }

    @Produces
    @Default
    public EntityManager getEntityManager() {
        return this.emf.createEntityManager();
    }

    public void close(@Disposes EntityManager entityManager) {
        // Destroy Entity Manager
        if (!entityManager.getTransaction().getRollbackOnly()
                && entityManager.getTransaction().isActive()) {
            // Only commit when rransaction is active and
            //  transaction was not rollbacked
            entityManager.getTransaction().commit();
        }
        entityManager.close();
    }
   
}
