package code.elif.catalogservice.domain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CatalogController {

    @GetMapping(path = "/greeting/{name}")
    public ResponseEntity<String> getGreetingMessage(@PathVariable("name") String name) {
        return ResponseEntity.ok("Hello " + name);
    }
}
