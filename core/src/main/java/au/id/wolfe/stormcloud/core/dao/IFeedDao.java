package au.id.wolfe.stormcloud.core.dao;

import java.util.List;

import au.id.wolfe.stormcloud.core.model.Feed;

/**
 *
 * Feed data access object
 * 
 */
public interface IFeedDao {

    public List<Feed> getAll();
    
    public Feed getById(String id);

    public boolean save(Feed feed);

    public boolean update(Feed feed);

    public boolean delete(Feed feed);
}
