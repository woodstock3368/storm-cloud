package au.id.wolfe.stormcloud.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static junit.framework.Assert.*;
import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import au.id.wolfe.stormcloud.core.dao.IProfileDao;
import au.id.wolfe.stormcloud.core.model.Profile;

import java.util.Date;
import java.util.List;
import java.util.UUID;


/**
 *
 * Unit test for the Profile DAO
 * 
 */
public class ProfileDaoSpringJpaTest {

    private ApplicationContext ctx;
    private IProfileDao profileDao;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    public ProfileDaoSpringJpaTest() {

        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        profileDao = (IProfileDao) ctx.getBean("iProfileDao");

        log.info("Application Context Loaded");
    }

    @Test
    public void testGetAll() {

        log.info("Test get all =================================");

        List<Profile> profileList = profileDao.getAll();

        assertNotNull(profileList);

    }

    @Test
    public void testSave() {

        log.info("Test Save Data =================================");

        Profile profile = new Profile();

        profile.setId(UUID.randomUUID().toString());
        profile.setName("testing profile");
        profile.setHref("http://www.wolfe.id.au/coolprofile");
        profile.setUpdated(new Date());
        profile.setCreated(new Date());

        assertTrue(profileDao.save(profile));
    }

    @Test
    public void testUpdate() {

        // use the power of immutable stuff
        final String newName = "gary's profile";
        final String garyProfileId = "6650eeeb-9d39-4c21-9a1a-a81bb1f37b87";

        log.info("Test Update Data =================================");

        Profile profile = profileDao.getById(garyProfileId);

        profile.setName(newName);
        profile.setUpdated(new Date());

        assertTrue(profileDao.update(profile));

        Profile updatedProfile = profileDao.getById(garyProfileId);

        assertEquals(newName, updatedProfile.getName());
    }
}
