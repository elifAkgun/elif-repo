package code.elif.ws.api.ApiGateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class GlobalFilterConfiguration {

    Logger logger = LoggerFactory.getLogger(PostFilter.class);

    @Bean
    public GlobalFilter secondFilter() {
        return (exchange, chain) ->
        {
            logger.info("second pre-filter is executed");
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                logger.info("second post-filter is executed");
            }));
        };
    }

    @Bean
    public GlobalFilter thirdFilter() {
        return (exchange, chain) ->
        {
            logger.info("third pre-filter is executed");
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                logger.info("third-post filter is executed");
            }));
        };
    }

    @Bean
    public GlobalFilter fourthFilter() {
        return (exchange, chain) ->
        {
            logger.info("fourth pre-filter is executed");
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                logger.info("fourth post-filter is executed");
            }));
        };
    }
}
