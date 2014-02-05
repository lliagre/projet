package fr.plil.sio.web;

import fr.plil.sio.jpa.JpaAppConfiguration;
import fr.plil.sio.jpa.OwnerService;
import javax.annotation.Resource;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaAppConfiguration.class})
@TransactionConfiguration
@Transactional
public class PersistenceIntegrationTest {
    
    @Resource
    private OwnerService ownerService;
    
    @Test
    public void testOwnerService() {
        assertNotNull(ownerService);
        ownerService.createOwner("owner");
        assertEquals(1,ownerService.findAll().size());
    }
}
