package code.elif.webfluxdemo.webclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    public static final String HTTP_LOCALHOST_8080 = "http://localhost:8080";

    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                .baseUrl(HTTP_LOCALHOST_8080)
                .build();
    }
}
