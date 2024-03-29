package code.elif.api.AccountManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController {


    private Environment environment;

    public AccountController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/check/status")
    public String status() {
        return "Working on port : " + environment.getProperty("local.server.port")
                + " secret token  is \"" + environment.getProperty("token.secret") + "\"";
    }
}
