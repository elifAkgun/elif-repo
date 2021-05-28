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
import org.springframework.web.client.RestTemplate;

@Controller
public class UserController {

    @Autowired
    OAuth2AuthorizedClientService oAuth2AuthorizedClientService;

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/user")
    public String showUser(Model model, @AuthenticationPrincipal OidcUser principal){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        OAuth2AuthenticationToken oAuth2Token = (OAuth2AuthenticationToken)authentication;

        OAuth2AuthorizedClient oAuth2AuthorizedClient =
                oAuth2AuthorizedClientService.loadAuthorizedClient
                        (oAuth2Token.getAuthorizedClientRegistrationId(),
                       oAuth2Token.getName() );

        String jwtToken = oAuth2AuthorizedClient.getAccessToken().getTokenValue();

        String url = "http://localhost:8082/users/status/check";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Bearer " + jwtToken);

        HttpEntity httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<String> responseEntity =
                restTemplate.exchange(url, HttpMethod.GET, httpEntity,
                        new ParameterizedTypeReference<>() {
                        });

        String status = responseEntity.getBody();

        model.addAttribute("authenticationName",authentication.getName());

        model.addAttribute("status", status);
        return "user";
    }
}
