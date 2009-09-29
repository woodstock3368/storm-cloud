package au.id.wolfe.stormcloud.core;

import au.id.wolfe.stormcloud.core.model.Domain;
import au.id.wolfe.stormcloud.core.dao.IDomainDao;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import static junit.framework.Assert.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 * Unit test for the Domain DAO
 *
 */
public class DomainDaoSpringJpaTest {

    private ApplicationContext ctx;
    private IDomainDao domainService;
    private Logger log = LoggerFactory.getLogger(this.getClass());

    public DomainDaoSpringJpaTest() {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        domainService = (IDomainDao) ctx.getBean("iDomainDao");
        log.info("Application Context Loaded");
    }

    @Test
    public void testGetAll() {
        log.info("Test get all =================================");

        List<Domain> domainsCollection = domainService.getAll();

        assertNotNull(domainsCollection);
    }

    @Test
    public void testSave() {
        log.info("Test Save Data =================================");
        Domain domain = new Domain();

        domain.setId(UUID.randomUUID().toString());

        domain.setName("signals");
        domain.setTitle("Signals domain");
        domain.setUpdated(new Date());
        domain.setCreated(new Date());

        assertTrue(domainService.save(domain));
    }

    @Test
    public void testUpdate() {

        // use the power of immutable stuff
        final String newTitle = "Default domain title";
        final String defaultDomain = "fd70338a-4584-483e-9bf4-59c7c7b31e85";

        log.info("Test Update Data =================================");

        Domain domain = domainService.getById(defaultDomain);

        assertNotNull(domain);

        domain.setTitle(newTitle);

        assertTrue(domainService.update(domain));

        Domain domainUpdated = domainService.getById(defaultDomain);

        assertEquals(newTitle, domainUpdated.getTitle());

    }

}
