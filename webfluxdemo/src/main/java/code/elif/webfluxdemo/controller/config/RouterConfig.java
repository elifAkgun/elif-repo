package code.elif.webfluxdemo.controller.config;

import code.elif.webfluxdemo.controller.response.FailedResponse;
import code.elif.webfluxdemo.exception.InputValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

@Configuration
@RequiredArgsConstructor
public class RouterConfig {

    private final RequestHandler requestHandler;

    /**
     * May be more than one router function in your project.
     *
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> highLevelRouter() {
        return RouterFunctions.route()
                .path("router", this::serverResponseRouterFunction)
                .build();
    }

    private RouterFunction<ServerResponse> serverResponseRouterFunction() {
        return RouterFunctions.route()
                .GET("square/{input}", RequestPredicates.path("/[0-9]|1[0-9]|20"), requestHandler::square)
                .GET("square/{input}", request ->
                        ServerResponse.badRequest()
                                .bodyValue("Number only should be between 1-20"))
                .GET("multiplicationTable/{input}", requestHandler::getMultiplicationTable)
                .POST("multiplication", requestHandler::getMultiplication)
                .onError(InputValidationException.class, exceptionHandler())
                .build();
    }

    /**
     * May be more than one router function in your project.
     *
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> serverResponseRouterFunction2() {
        return RouterFunctions.route()
                .GET("router/square1/{input1}", requestHandler::square)
                .GET("router/multiplicationTable1/{input}", requestHandler::getMultiplicationTable)
                .POST("router/multiplication1", requestHandler::getMultiplication)
                .onError(InputValidationException.class, exceptionHandler())
                .build();
    }

    private BiFunction<Throwable, ServerRequest, Mono<ServerResponse>> exceptionHandler() {
        return (err, req) -> {
            InputValidationException ex = (InputValidationException) err;
            FailedResponse failedResponse = new FailedResponse();
            failedResponse.setMessage(ex.getMessage());
            failedResponse.setErrorCode(ex.getCode());
            failedResponse.setInput(ex.getInput());
            return ServerResponse.badRequest().bodyValue(failedResponse);
        };
    }
}
