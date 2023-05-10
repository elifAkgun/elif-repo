package code.elif.webfluxdemo.config;

import code.elif.webfluxdemo.controller.response.FailedResponse;
import code.elif.webfluxdemo.exception.InputValidationException;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

public class RouterExceptionHelper {

    public static BiFunction<Throwable, ServerRequest, Mono<ServerResponse>> exceptionHandler() {
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
