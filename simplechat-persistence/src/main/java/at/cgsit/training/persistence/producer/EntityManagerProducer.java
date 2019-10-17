package at.cgsit.training.persistence.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class EntityManagerProducer {

    // @Produces
	@PersistenceContext(unitName = "chatsPU")
    private EntityManager em;
	
	//@PersistenceContext(unitName = "chatsPU")
    // private EntityManagerFactory entityManagerFactory;


//    @PersistenceContext(unitName = "chatsPU")
//    public void setEntityManager(EntityManager entityManager) {
//        this.em = entityManager;
//    }	
//	
	
    @Produces
    @Default
    public EntityManager getEntityManager() {
    	return this.em;
        // return this.entityManagerFactory.createEntityManager();
    }
   
}