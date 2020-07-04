package com.elif.rest;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;


@RequestScoped
public class JaxRsClient {

	private Client client;
    WebTarget webTarget;

    private static final String API_ENDPOINT = "https://sandbox-api.qnbfinansbank.com/v0/credit-cards"; //https://haveibeenpwned.com/api/v2/breachedaccount/{account}


    @PostConstruct
    private void init() {
        client = ClientBuilder.newBuilder().connectTimeout(7, TimeUnit.SECONDS)
                .readTimeout(3, TimeUnit.SECONDS).build();
        webTarget = client.target(API_ENDPOINT);
    }

    @PreDestroy
    private void destroy() {
        if (client != null) {
            client.close();
        }

    }

    public String getCards(String token) {
        return webTarget.request(MediaType.TEXT_PLAIN)
                .header(HttpHeaders.AUTHORIZATION, token).get(String.class);
    }

}


