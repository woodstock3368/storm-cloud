package au.id.wolfe.stormcloud.core.dao;

import au.id.wolfe.stormcloud.core.model.Domain;
import java.util.List;

/**
 *
 * Domain data access object
 *
 */
public interface IDomainDao {

    public List<Domain> getAll();

    public Domain getById(String id);

    public boolean save(Domain domain);

    public boolean delete(Domain domain);

    public boolean update(Domain domain);

}
