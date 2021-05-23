package code.elif.ws.api.ResourceServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    Environment environment;

    @GetMapping("/status/check")
    public String status() {
        return "Working... on port" + environment.getProperty("local.server.port");
    }

    @Secured("ROLE_developer")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        return "Deleting id" + id;
    }

    @PreAuthorize("hasAnyAuthority('ROLE_developer')")
    @PutMapping("/{id}")
    public String create(@PathVariable String id) {
        return "Creating id" + id;
    }

    @PostAuthorize("hasRole('developer1') or #id == #jwt.subject")
    @GetMapping("/{id}")
    public String getId(@PathVariable String id, @AuthenticationPrincipal Jwt jwt) {
        return "Returning id" + id;
    }

}
