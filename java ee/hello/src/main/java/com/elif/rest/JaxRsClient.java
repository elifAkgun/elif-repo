package com.elif.rest;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.elif.entity.Customer;

@RequestScoped
public class JaxRsClient {

	private Client client;
	WebTarget webTarget;

	private static final String API_ENDPOINT = "https://sandbox-api.qnbfinansbank.com/v0/credit-cards";

	@PostConstruct
	private void init() {
		client = ClientBuilder.newBuilder().connectTimeout(7, TimeUnit.SECONDS).readTimeout(3, TimeUnit.SECONDS)
				.build();
		webTarget = client.target(API_ENDPOINT);
	}

	@PreDestroy
	private void destroy() {
		if (client != null) {
			client.close();
		}

	}

	public String getCards(String token, String cardId) {

		if (cardId != null) {
			return webTarget.path("{card-id}").resolveTemplate("card-id", cardId).request(MediaType.TEXT_PLAIN)
					.header(HttpHeaders.AUTHORIZATION, token).get(String.class);
		} else {
			return webTarget.request(MediaType.TEXT_PLAIN).header(HttpHeaders.AUTHORIZATION, token).get(String.class);
		}
	}

	public void postEmployeeToSSE(Customer customer) {
		String json = JsonbBuilder.create().toJson(customer);

		int status = client.target("http://localhost:8080/event/api/v1/sse-path").request(MediaType.TEXT_PLAIN)
				.post(Entity.text(json)).getStatus();

		System.out.println("Status received " + status);
		System.out.println(json);

	}

}
