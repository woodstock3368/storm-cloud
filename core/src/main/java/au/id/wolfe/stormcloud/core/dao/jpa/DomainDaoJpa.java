package au.id.wolfe.stormcloud.core.dao.jpa;

import au.id.wolfe.stormcloud.core.model.Domain;
import au.id.wolfe.stormcloud.core.dao.IDomainDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * Domain data access object which uses JPA.
 * 
 */
@Repository("iDomainDao")
@Transactional(readOnly = true)
public class DomainDaoJpa implements IDomainDao {

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
    public List<Domain> getAll() {
        return entityManager.createNamedQuery("Domain.findAll").getResultList();
    }

    @Override
    public Domain getById(String id) {
        return entityManager.find(Domain.class, id);
    }

    @Override
    public boolean save(Domain domain) {
        entityManager.persist(domain);
        entityManager.flush();
        return true;
    }

    @Override
    public boolean update(Domain domain) {
        entityManager.merge(domain);
        entityManager.flush();
        return true;
    }

    @Override
    public boolean delete(Domain domain) {
        domain = entityManager.getReference(Domain.class, domain.getId());
        if (domain == null) {
            return false;
        }
        entityManager.remove(domain);
        entityManager.flush();
        return true;
    }
}
