package code.elif.controller;

import code.elif.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("id")
@RequestMapping(value = "/session")
public class SessionAttributeController {

    private VisitorService visitorService;


    @Autowired
    public SessionAttributeController(VisitorService visitorService) {
        this.visitorService = visitorService;
    }

    @ModelAttribute(name = "id")
    public Integer getVisitorCount() {
        visitorService.updateVisitorCount();
        return visitorService.getVisitorCount();
    }

    @RequestMapping(value = "visitorId")
    public ModelAndView getVisitorID(@ModelAttribute("id") Integer id){
        ModelAndView modelAndView = new ModelAndView("visitor-id");
        modelAndView.addObject("id",  id);
        modelAndView.addObject("count",  visitorService.getVisitorCount());
        return modelAndView;
    }

    @RequestMapping(value = "visitorIdSession")
    public ModelAndView getVisitorId(@SessionAttribute(name = "id") Integer id){
        ModelAndView modelAndView = new ModelAndView("visitor-id");
        modelAndView.addObject("id",  id);
        modelAndView.addObject("count",  visitorService.getVisitorCount());
        return modelAndView;
    }
}
