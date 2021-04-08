package code.elif.controller;

import code.elif.model.Organization;
import code.elif.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/test")
public class ModelAttributeController {

    Logger logger = LoggerFactory.getLogger(ModelAttributeController.class);

    @ModelAttribute
    public void test1(Model model) {
        logger.info("model attribute -> test1 method is called.");
        model.addAttribute("testDataAttribute1", "testDataAttribute1 1 data");
        model.addAttribute("testDataAttribute2", "testDataAttribute1 2 data");
    }

    @ModelAttribute(name = "orgModel")
    public Organization test2() {
        Organization organization = new Organization();
        organization.setSlogan("GREAT!");
        organization.setPostalCode("76553");
        organization.setEmployeeCount(14);
        organization.setYearOfIncorporation(2000);
        organization.setCompanyName("GREAT Company");
        return organization;
    }

    @RequestMapping(value = "home")
    public String home() {
        logger.info("home method is called.");
        return "model-attribute-home";
    }

    @RequestMapping(value = "home2")
    public String home2(Model model) {
        model.addAttribute("modelAttribute1", "Model Attribute value");
        model.addAttribute("modelAttribute2", "Model Attribute value 2");
        logger.info("home2 method is called.");
        return "model-attribute-home";
    }

    @RequestMapping(value = "home3")
    public ModelAndView home3() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("model-attribute-home");

        Organization organization = new Organization();
        organization.setSlogan("This is a company!");
        organization.setPostalCode("34");
        organization.setEmployeeCount(4);
        organization.setYearOfIncorporation(1989);
        organization.setCompanyName("Elif Code Company");

        modelAndView.addObject("organizationModelAndView", organization);

        return modelAndView;
    }

}
