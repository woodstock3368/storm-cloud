package au.id.wolfe.stormcloud.core.dao.jpa;

import au.id.wolfe.stormcloud.core.model.Profile;
import au.id.wolfe.stormcloud.core.dao.IProfileDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * Profile data access object which uses JPA.
 * 
 */
@Repository("iProfileDao")
@Transactional(readOnly = true)
public class ProfileDaoJpa implements IProfileDao {

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
    public List<Profile> getAll() {
        return entityManager.createNamedQuery("Profile.findAll")
                .getResultList();
    }

    @Override
    public Profile getById(String id) {
        return entityManager.find(Profile.class, id);
    }

    @Override
    public boolean save(Profile profile) {
        entityManager.persist(profile);
        entityManager.flush();
        return true;
    }

    @Override
    public boolean update(Profile profile) {
        entityManager.merge(profile);
        entityManager.flush();
        return true;
    }

    @Override
    public boolean delete(Profile profile) {
        profile = entityManager.getReference(Profile.class, profile.getId());
        if (profile == null) {
            return false;
        }
        entityManager.remove(profile);
        entityManager.flush();
        return true;
    }

}
