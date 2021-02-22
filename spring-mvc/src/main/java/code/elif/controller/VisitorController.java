package code.elif.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/visitor")

public class VisitorController {


    @RequestMapping("/time")
    public ModelAndView time(
            @RequestAttribute(name = "time", required = false) LocalDateTime time,
            @RequestAttribute(name = "sessionStartTime",required = false) LocalDateTime sessionStartTime) {
        ModelAndView modelAndView = new ModelAndView("visitor-session");
        modelAndView.addObject("time",  time);
        modelAndView.addObject("sessionStartTime",  sessionStartTime);
        return modelAndView;
    }
}
