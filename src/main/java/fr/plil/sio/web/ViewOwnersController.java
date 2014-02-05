package fr.plil.sio.web;

import fr.plil.sio.jpa.Owner;
import fr.plil.sio.jpa.OwnerService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/owners")
public class ViewOwnersController {
    
    @Resource
    private OwnerService ownerService;
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView viewOwners() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("viewOwner");
        mav.addObject("owners", ownerService.findAll());
        return mav;
    }

    @RequestMapping(value = "/list.json", method = RequestMethod.GET,produces="application/json")
    public @ResponseBody List<Owner> viewOwnersJson() {
        return ownerService.findAll();
    }
    
    
    public void setOwnerService(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
}
