package com.elif.rest;


import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;

import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.elif.config.security.ApplicationState;
import com.elif.entity.ApplicationUser;
import com.elif.service.impl.ApplicationUserService;
import com.elif.util.SecurityUtil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Path("users")
@Consumes("application/json")
@Produces("application/json")
public class ApplicationUsersResource {

    @Inject
    private ApplicationState applicationState;
	
    @Inject
    private SecurityUtil securityUtil;

    @Inject
    private ApplicationUserService service;

    @Context
    private UriInfo uriInfo;

    @Inject
    private Logger logger;


    @POST
    public Response createUser(@Valid ApplicationUser user) {
        service.save(user);


        return Response.created(uriInfo.getAbsolutePathBuilder().path(user.getId().toString()).build())
                .status(Response.Status.OK).build();
    }


    @POST
    @Path("login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response login(@FormParam("email") @NotEmpty(message = "Email must be set") String email,
                          @NotEmpty(message = "Password must be set") @FormParam("password") String password) {



            if (!securityUtil.authenticateUser(email, password)) {
                throw new SecurityException("Email or password incorrect");
            }
            applicationState.setEmail(email);
            String token = getToken(email);

            return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();

        }



    private String getToken(String email) {
        Key key = securityUtil.generateKey(email);


        String token = Jwts.builder().setSubject(email).setIssuer(uriInfo.getAbsolutePath().toString())

                .setIssuedAt(new Date()).setExpiration(securityUtil.toDate(LocalDateTime.now().plusMinutes(15)))

                .signWith(SignatureAlgorithm.HS512, key).setAudience(uriInfo.getBaseUri().toString())

                .compact();

        logger.log(Level.INFO, "Generated token is {0}", token);


        return token;
    }

}




