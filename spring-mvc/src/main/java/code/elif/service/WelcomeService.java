package code.elif.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService implements GenericWelcomeService {

    public String sayHello(String name){
        return "Hello" + name;
    }

}
