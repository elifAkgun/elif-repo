package code.elif.controller;

import code.elif.model.Visitor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/visitorRegister")
@SessionAttributes(names={"visitors", "count"})

public class VisitorController {

    @ModelAttribute(name = "count")
    public AbstractMap.SimpleEntry getVisitorCount() {
        return new AbstractMap.SimpleEntry(1,1);
    }

    @ModelAttribute(name = "visitors")
    public List<Visitor> getVisitor() {
        return new ArrayList<>();
    }

    @RequestMapping("/visitorFormPage")
    public ModelAndView visitorFormPage() {
        ModelAndView modelAndView = new ModelAndView("visitor-form-page",
                "visitorData", new Visitor());
        return modelAndView;
    }

    @RequestMapping(value = "/visitor", method = RequestMethod.POST)
    public ModelAndView addVisitor(@ModelAttribute("visitorData") Visitor visitor,
                                   SessionStatus sessionStatus,
                                   @SessionAttribute(name="visitors",required = false) ArrayList<Visitor> visitors,
                                   @SessionAttribute(name="count",required = false) AbstractMap.SimpleEntry<Integer,Integer> count,
                                   @SessionAttribute(name = "sessionStartTime", required = false) LocalDateTime sessionStartTime,
                                   @RequestAttribute(name = "time", required = false) LocalDateTime time) {

        count.setValue(count.getValue()+1);
        visitors.add(visitor);

        if (count.getValue() == 5) {
            sessionStatus.setComplete();
        }

        ModelAndView modelAndView = new ModelAndView("visitor-session", "visitors", visitors);
        modelAndView.addObject("time", time);
        modelAndView.addObject("sessionStartTime", sessionStartTime);
        return modelAndView;
    }
}
