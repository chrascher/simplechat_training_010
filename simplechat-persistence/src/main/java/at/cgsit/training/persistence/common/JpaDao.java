package at.cgsit.training.persistence.common;

import at.cgsit.training.persitence.dao.Dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

/**
 *
 */
public abstract class JpaDao<T> implements Dao<T> {

    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManagerIn) {
        this.entityManager = entityManagerIn;
    }

    protected abstract Class<T> getEntityClass();

    protected String getSimpleClassName() {
        return getEntityClass().getSimpleName();
    }

    @Override
    public Optional<T> get(long id) {
        return Optional.ofNullable(entityManager.find(getEntityClass(), id));
    }

    @Override
    public List<T> getAll() {
        // for example : "SELECT e FROM ChatUser e"
        Query query = entityManager.createQuery("SELECT e FROM " + getSimpleClassName() + " e", getEntityClass());
        return query.getResultList();
    }

    @Override
    public void save(T t) {
        // TODO
    }

    @Override
    public void update(T t, String[] params) {
        // TODO
    }

    @Override
    public void delete(T t) {
        // TODO
    }
}
