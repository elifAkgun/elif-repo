package code.elif.service.impl;

import code.elif.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String getHelloMessage(String user) {
        return "Hello " + user + " !";
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to this Demo Application!";
    }
}
