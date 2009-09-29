package au.id.wolfe.stormcloud.core.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import au.id.wolfe.stormcloud.core.dao.IPipeDao;
import au.id.wolfe.stormcloud.core.model.Pipe;

/**
 * 
 * Pipe data access object which uses JPA.
 * 
 */
@Repository("iPipeDao")
@Transactional(readOnly = true)
public class PipeDaoJpa implements IPipeDao{
    
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Pipe> getAll() {
        return entityManager.createNamedQuery("Pipe.findAll")
                .getResultList();
    }

    @Override
    public Pipe getById(String id) {
        return entityManager.find(Pipe.class, id);
    }

    @Override
    public boolean save(Pipe pipe) {
        entityManager.persist(pipe);
        entityManager.flush();
        return true;
    }

    @Override
    public boolean update(Pipe pipe) {
        entityManager.merge(pipe);
        entityManager.flush();
        return true;
    }

    @Override
    public boolean delete(Pipe pipe) {
        pipe = entityManager.getReference(Pipe.class, pipe.getId());
        if (pipe == null) {
            return false;
        }
        entityManager.remove(pipe);
        entityManager.flush();
        return true;
    }

}
