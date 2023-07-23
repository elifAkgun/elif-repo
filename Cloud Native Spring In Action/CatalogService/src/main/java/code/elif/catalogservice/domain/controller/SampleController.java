package code.elif.catalogservice.domain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping(path = "/greeting/{name}")
    public ResponseEntity<String> getGreetingMessage(@PathVariable("name") String name) {
        return ResponseEntity.ok("Hello " + name);
    }
}
