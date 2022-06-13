package code.elif.controller;

import code.elif.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class DemoController {

    private DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/hello")
    public String hello(Model model, @RequestParam String user,@RequestParam int age){
        model.addAttribute("helloMessage", demoService.getHelloMessage(user));
        model.addAttribute("age",age);
        log.info("model : {}",model);
        return "hello";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcomeMessage() is called.");
        return demoService.getWelcomeMessage();
    }
}
