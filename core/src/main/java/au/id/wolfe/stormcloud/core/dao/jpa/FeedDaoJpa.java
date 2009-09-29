package au.id.wolfe.stormcloud.core.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import au.id.wolfe.stormcloud.core.dao.IFeedDao;
import au.id.wolfe.stormcloud.core.model.Feed;

/**
 *
 * Feed data access object which uses JPA.
 *
 */
@Repository("iFeedDao")
@Transactional(readOnly = true)
public class FeedDaoJpa implements IFeedDao{

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Feed> getAll() {
        return entityManager.createNamedQuery("Feed.findAll").getResultList();
    }

    @Override
    public Feed getById(String id) {
        return entityManager.find(Feed.class, id);
    }

    @Override
    public boolean save(Feed feed) {
        entityManager.persist(feed);
        entityManager.flush();
        return true;
    }

    @Override
    public boolean update(Feed feed) {
        entityManager.merge(feed);
        entityManager.flush();
        return true;
    }
    
    @Override
    public boolean delete(Feed feed) {
        feed = entityManager.getReference(Feed.class, feed.getId());
        if (feed == null) {
            return false;
        }
        entityManager.remove(feed);
        entityManager.flush();
        return true;
    }


}
