package code.elif.ws.api.ResourceServer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RequestMapping("/token")
@RestController
public class TokenController {

    @RequestMapping("/jwt")
    public String getToken(@AuthenticationPrincipal Jwt jwt) throws JsonProcessingException {
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = Obj.writeValueAsString(jwt);
        return jsonStr;
    }

    @RequestMapping("/jwt/map")
    public Map<String, Object> getTokenWithMap(@AuthenticationPrincipal Jwt jwt) {
        return Collections.singletonMap("token",jwt);
    }

    @RequestMapping("/jwt/object")
    public Jwt getTokenWithObject(@AuthenticationPrincipal Jwt jwt) {
        return jwt;
    }
}
