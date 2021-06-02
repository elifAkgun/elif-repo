package code.elif.app.ws.mobileappws.controller;

import code.elif.app.ws.mobileappws.exception.UserException;
import code.elif.app.ws.mobileappws.model.UserDTO;
import code.elif.app.ws.mobileappws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    private final Environment environment;

    @Autowired
    public UserController(UserService userService, Environment environment) {
        this.userService = userService;
        this.environment = environment;
    }

    @GetMapping("/status/check")
    public String statusCheck() {
        return "Working... on : " + environment.getProperty("local.server.port");
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers(@RequestParam(value = "page", required = false) Integer page,
                                               @RequestParam(value = "order", defaultValue = "desc") String order) {
        List<UserDTO> list = userService.getUsers();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserDTO> getUser(@PathVariable(name = "userId") String userId) {
        UserDTO user = userService.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
                            MediaType.APPLICATION_XML_VALUE},
                consumes = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO user) {
        UserDTO createdUser= userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping(path ="/{userId}" ,produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserDTO> updateUser(@PathVariable String userId,@Valid @RequestBody UserDTO user) {
        UserDTO userDTO = userService.updateUser(userId, user);
        return new ResponseEntity<>(userDTO,HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path ="/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

}
