package code.elif.webfluxdemo.config;

import code.elif.webfluxdemo.exception.InputValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

import static code.elif.webfluxdemo.config.RouterExceptionHelper.exceptionHandler;

@Configuration
@RequiredArgsConstructor
public class CalculatorRouterConfig {

    private final CalculatorRequestHandler requestHandler;

    /**
     * May be more than one router function in your project.
     *
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> highLevelRouterForCalculator() {
        return RouterFunctions.route()
                .path("router", this::serverResponseRouterFunction)
                .build();
    }

    private RouterFunction<ServerResponse> serverResponseRouterFunction() {
        return RouterFunctions.route()
                .GET("/square/{input}", requestHandler::square)
                .POST("calculator", isOperation("*"), requestHandler::getMultiplication)
                .POST("calculator", isOperation("/"), requestHandler::getDivision)
                .POST("calculator", isOperation("-"), requestHandler::getSubtraction)
                .POST("calculator", isOperation("+"), requestHandler::getAddition)
                .POST("calculator", request -> ServerResponse.badRequest().bodyValue("Operation should be set! (*,/,+,-)"))
                .onError(InputValidationException.class, exceptionHandler())
                .build();
    }

    private static RequestPredicate isOperation(String operation) {
        return RequestPredicates.headers(headers ->
                operation.equals(headers.asHttpHeaders()
                        .toSingleValueMap().get("operation")
                ));
    }


}
