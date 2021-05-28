package code.elif.api.ws.WebClient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
public class UserControllerWithWebClient {

    @Autowired
    WebClient webClient;

    @GetMapping("/user2")
    public String showUser(Model model, @AuthenticationPrincipal OidcUser principal) {

        String url = "http://localhost:8082/users/status/check";

        String status = webClient.get().uri(url).retrieve()
                .bodyToMono(new ParameterizedTypeReference<String>() {
                }).block();


        model.addAttribute("authenticationName", principal.getName());
        model.addAttribute("status", status);
        return "user";
    }
}
