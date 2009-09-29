package au.id.wolfe.stormcloud.core;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static junit.framework.Assert.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import au.id.wolfe.stormcloud.core.dao.IFeedDao;
import au.id.wolfe.stormcloud.core.model.Feed;


/**
*
* Unit test for the Feed DAO
*
*/
public class FeedDaoSpringJpaTest {

    private ApplicationContext ctx;
    
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    private IFeedDao feedDao;

    public FeedDaoSpringJpaTest(){

        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        feedDao = (IFeedDao)ctx.getBean("iFeedDao");
        
        log.info("Application Context Loaded");

    }
    
    @Test
    public void testGetAll() {

        log.info("Test get all =================================");

        List<Feed> feedList = feedDao.getAll();
        
        assertNotNull(feedList);
    }
    
    @Test
    public void testSave() {

        log.info("Test Save Data =================================");
        
        Feed feed = new Feed();
        
        feed.setId(UUID.randomUUID().toString());
        feed.setName("random");
        feed.setType("direct");
        feed.setTitle("Some Random Event Notifications");
        feed.setUpdated(new Date());
        feed.setCreated(new Date());
        
        assertTrue(feedDao.save(feed));

    }
    
    @Test
    public void testUpdate() {

        // use the power of immutable stuff
        final String newTitle = "Announcement feed.";
        final String updateFeedId = "f6363a05-4354-4053-9fdc-16e776a24d0d";

        log.info("Test Update Data =================================");
        
        Feed feed = feedDao.getById(updateFeedId);
            
        log.info("Feed before update " + feed.toString());
        
        // get the hash code before update
        int hashcodeBeforeUpdate = feed.hashCode();

        feed.setTitle(newTitle);
        feed.setUpdated(new Date());
        
        assertTrue(feedDao.update(feed));
        
        Feed updatedFeed = feedDao.getById(updateFeedId);

        log.info("Feed after update " + feed.toString());
        
        assertEquals(newTitle, updatedFeed.getTitle());

        // get the hash code after update
        int hashcodeAfterUpdate = feed.hashCode();
        
        // This check is very important as we use the hash code for caching entities 
        // so it must change when the entity is updated.
        assertNotSame(hashcodeBeforeUpdate, hashcodeAfterUpdate);
        
    }
}
