package code.elif.webfluxdemo.config;

import code.elif.webfluxdemo.service.MathReactiveService;
import code.elif.webfluxdemo.service.output.MultiplicationTableOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RequestHandler {

    private final MathReactiveService mathReactiveService;

    public Mono<ServerResponse> getMultiplicationTable(ServerRequest serverRequest) {
        String input = serverRequest.pathVariable("input");
        Flux<MultiplicationTableOutput> multiplicationTable = mathReactiveService.getMultiplicationTable(Integer.parseInt(input));
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(multiplicationTable, MultiplicationTableOutput.class);
    }
}
