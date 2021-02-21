package code.elif.controller;

import code.elif.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("count")
@RequestMapping(value = "/session")
public class SessionAttributeController {

    private VisitorService visitorService;


    @Autowired
    public SessionAttributeController(VisitorService visitorService) {

        this.visitorService = visitorService;
    }

    @ModelAttribute(name = "count")
    public Integer getVisitorCount() {
        visitorService.updateVisitorCount();
        return visitorService.getVisitorCount();
    }

    @RequestMapping(value = "visitorCount")
    public ModelAndView getVisitorCount(@ModelAttribute("count") Integer count){
        ModelAndView modelAndView = new ModelAndView("visitor-count");
        modelAndView.addObject("count",  visitorService.getVisitorCount());
        return modelAndView;
    }

}
