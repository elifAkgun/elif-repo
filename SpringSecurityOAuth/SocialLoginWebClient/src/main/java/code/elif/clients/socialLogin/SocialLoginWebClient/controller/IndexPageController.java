package code.elif.clients.socialLogin.SocialLoginWebClient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexPageController {

    @GetMapping("/")
    public String displayPage(Model model) {
        return "index";
    }
}
