package code.elif.app.ws.mobileappws.controller;

import code.elif.app.ws.mobileappws.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {


    @GetMapping(value = "/{userId}", produces = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public User getUser(@PathVariable(name = "userId") Integer userId){
        User user = new User(userId,"Elif","Akgun");
        return user;
    }

    @GetMapping
    public String getUsers(@RequestParam(value = "page", required = false) Integer page,
    @RequestParam(value ="order", defaultValue = "desc") String order){
        if(page!=null) {
            return "GetMapping user executed for page : " + page + " order : "+ order;
        }
        return "GetMapping user executed " + order;
    }

    @PostMapping
    public String createUser(){
        return "PostMapping user executed";
    }

    @PutMapping
    public String updateUser(){
        return "PutMapping user executed";
    }

    @DeleteMapping
    public String deleteUser(){
        return "DeleteMapping user executed";
    }

}
