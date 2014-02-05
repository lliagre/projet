package fr.plil.sio.web;

import fr.plil.sio.jpa.Owner;
import fr.plil.sio.jpa.OwnerService;
import java.util.List;
import javax.annotation.Resource;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppConfig.class})
@TransactionConfiguration
@Transactional
@WebAppConfiguration
public class WebIntegrationTest {
 
    @Resource
    private OwnerService ownerService;
    
    @Resource
    private ViewOwnersController viewOwners;
    
    @Test
    public void testOwnerGetList() {
        ownerService.createOwner("owner");
        ModelAndView mav = viewOwners.viewOwners();
        assertEquals("viewOwner",mav.getViewName());
        assertEquals(1, ((List<Owner>)mav.getModel().get("owners")).size());
    }
}
