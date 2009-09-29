package au.id.wolfe.stormcloud.core.dao;

import java.util.List;

import au.id.wolfe.stormcloud.core.model.Pipe;


public interface IPipeDao {
    public List<Pipe> getAll();
    
    public Pipe getById(String id);

    public boolean save(Pipe pipe);

    public boolean update(Pipe pipe);

    public boolean delete(Pipe pipe);

}
