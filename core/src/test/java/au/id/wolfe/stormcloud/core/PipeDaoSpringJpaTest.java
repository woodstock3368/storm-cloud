package au.id.wolfe.stormcloud.core;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import au.id.wolfe.stormcloud.core.dao.IPipeDao;
import au.id.wolfe.stormcloud.core.model.Pipe;

public class PipeDaoSpringJpaTest {

    private ApplicationContext ctx;
    private IPipeDao pipeDao;
    
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    public PipeDaoSpringJpaTest(){
        
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        pipeDao = (IPipeDao) ctx.getBean("iPipeDao");
        log.info("Application Context Loaded");
        
    }
    
    @Test
    public void testGetAll() {

        log.info("Test get all =================================");

        List<Pipe> pipeList = pipeDao.getAll();
        
        assertNotNull(pipeList);
    }
    
    @Test
    public void testSave() {

        log.info("Test Save Data =================================");

        Pipe pipe = new Pipe();
        
        pipe.setId(UUID.randomUUID().toString());
        pipe.setTitle("New Pipe");
        pipe.setType("direct");
        pipe.setUpdated(new Date());
        pipe.setCreated(new Date());
        
        log.info(pipe.toString());
        
        assertTrue(pipeDao.save(pipe));
        
    }
    
    @Test
    public void testUpdate(){
        
        // use the power of immutable stuff
        final String newTitle = "Data Feed Updated";
        final String updatePipeId = "90f197cb-a225-4cd4-b9ab-964bd79e9337";

        log.info("Test Update Data =================================");
        
        Pipe pipe = pipeDao.getById(updatePipeId);
        pipe.setTitle(newTitle);
        
        pipeDao.update(pipe);
        
        Pipe updatedPipe = pipeDao.getById(updatePipeId);
        
        assertEquals(newTitle, updatedPipe.getTitle());
        
        
    }
}
