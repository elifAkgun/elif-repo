package code.elif.controller;

import code.elif.service.GenericWelcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    private final GenericWelcomeService welcomeService;

    public WelcomeController(GenericWelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }

    @RequestMapping
    public String doWelcome(Model model){
        model.addAttribute("myInfo", welcomeService.sayHello("Elif"));
        return "welcomeNew";
    }
}
