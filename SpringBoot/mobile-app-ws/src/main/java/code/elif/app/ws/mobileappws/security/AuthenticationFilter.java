package code.elif.app.ws.mobileappws.security;

import code.elif.app.ws.mobileappws.model.LoginRequestModel;
import code.elif.app.ws.mobileappws.model.UserDTO;
import code.elif.app.ws.mobileappws.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.User;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private UserService userService;
    private Environment environment;
    public AuthenticationFilter(UserService userService, Environment environment, AuthenticationManager authenticationManager){
        this.userService = userService;
        this.environment = environment;
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        LoginRequestModel loginRequestModel = null;
        try {
            loginRequestModel = new ObjectMapper()
                    .readValue(request.getInputStream(), LoginRequestModel.class);

            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequestModel.getEmail(),
                            loginRequestModel.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //This method is called by spring framework. If the login attempt is successful then this method is called.
    //Method takes user details and generates jwt token which will be added response's header.
    //client application uses the jwt token for authorized endpoints.
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {

        String userName = ((User) authResult.getPrincipal()).getUsername();
        UserDTO userDTO = userService.getUserByEmail(userName);

        String token = Jwts.builder()
                .setSubject(userDTO.getEmail())
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(environment.getProperty("token.expiration_time"))))
                .signWith(SignatureAlgorithm.HS512,environment.getProperty("token.secret"))
                .compact();

        response.addHeader("token",token);
        response.addHeader("userId",userDTO.getUserId());
    }
}
