package code.elif.controller;

import code.elif.model.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ModelAttributeController {

    Logger logger = LoggerFactory.getLogger(ModelAttributeController.class);

    @RequestMapping(value = "home")
    public String home (){
        logger.info("home method is called.");
        return "model-attribute-home";
    }

    @RequestMapping(value = "home2")
    public String home2 (){
        logger.info("home2 method is called.");
        return "model-attribute-home";
    }

    @ModelAttribute
    public void test1(Model model){
        logger.info("model attribute -> test1 method is called.");
        model.addAttribute("testDataAttribute1","testDataAttribute1 1 data");
        model.addAttribute("testDataAttribute2","testDataAttribute1 2 data");
    }

}
