package fr.plil.sio.web;

import fr.plil.sio.jpa.Owner;
import fr.plil.sio.jpa.OwnerService;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.springframework.web.servlet.ModelAndView;

public class WebTest {

    @Test
    public void testOwnerGetList() {
        OwnerService ownerService = mock(OwnerService.class);
        Owner owner = new Owner();
        owner.setName("owner");
        List<Owner> owners = new LinkedList<Owner>();
        owners.add(owner);
        when(ownerService.findAll()).thenReturn(owners);
        ViewOwnersController controller = new ViewOwnersController();
        controller.setOwnerService(ownerService);
        ModelAndView mav = controller.viewOwners();
        assertEquals("viewOwner",mav.getViewName());
        assertEquals(1, ((List<Owner>)mav.getModel().get("owners")).size());
    }    
}
