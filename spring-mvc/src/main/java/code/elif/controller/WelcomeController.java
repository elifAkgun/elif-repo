package code.elif.controller;

import code.elif.service.GenericWelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @Qualifier("welcomeService")
    private final GenericWelcomeService welcomeService;

    @Autowired
    public WelcomeController(GenericWelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }

    @RequestMapping(value = "jndi-example")
    public String organisationJNDI(){
       return "jndi-example";
    }
}
