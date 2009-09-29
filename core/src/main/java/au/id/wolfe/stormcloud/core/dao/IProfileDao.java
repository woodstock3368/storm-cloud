package au.id.wolfe.stormcloud.core.dao;

import au.id.wolfe.stormcloud.core.model.Profile;
import java.util.List;

/**
 *
 * Profile data access object
 *
 */
public interface IProfileDao {

    public List<Profile> getAll();

    public Profile getById(String id);

    public boolean save(Profile profile);

    public boolean delete(Profile profile);

    public boolean update(Profile profile);

}
