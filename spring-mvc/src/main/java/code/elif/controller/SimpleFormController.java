package code.elif.controller;

import code.elif.model.Organization;
import code.elif.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleFormController {



    @RequestMapping(value = "simpleFormExample", method = RequestMethod.POST)
    public ModelAndView simpleFormExample(@ModelAttribute(value = "person") Person person, Model model){
        ModelAndView modelAndView = new ModelAndView();
        model.addAttribute("name",person.getName());
        model.addAttribute("surname",person.getSurName());
        modelAndView.setViewName("simple-form");
        return modelAndView;
    }

    @RequestMapping(value = "simpleFormExample", method = RequestMethod.GET)
    public ModelAndView simpleFormExample(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("simple-form");
        Person person = new Person();
        person.setName("Elif");
        person.setSurName("Akgün");
        modelAndView.addObject("person", person);
        return modelAndView;
    }
}
