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
public class RouterConfig {

    private final CalculatorRequestHandler requestHandler;

    /**
     * May be more than one router function in your project.
     *
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> highLevelRouter() {
        return RouterFunctions.route()
                .path("router", this::calculatorServerResponseRouterFunction)
                .build();
    }


    @Bean
    public RouterFunction<ServerResponse> calculatorServerResponseRouterFunction() {
        return RouterFunctions.route()
                .POST("router/multiplication1", requestHandler::getMultiplication)
                .onError(InputValidationException.class, exceptionHandler())
                .build();
    }


}
