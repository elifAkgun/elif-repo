package code.elif.webfluxdemo.config;

import code.elif.webfluxdemo.exception.InputValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

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
                .POST("calculator/multiplication", requestHandler::getMultiplication)
                .POST("calculator/division", requestHandler::getDivision)
                .POST("calculator/subtraction", requestHandler::getSubtraction)
                .POST("calculator/addition", requestHandler::getAddition)
                .onError(InputValidationException.class, exceptionHandler())
                .build();
    }


}
