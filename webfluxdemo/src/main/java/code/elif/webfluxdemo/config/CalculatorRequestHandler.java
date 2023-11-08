package code.elif.webfluxdemo.config;

import code.elif.webfluxdemo.service.CalculationService;
import code.elif.webfluxdemo.service.input.CalculationInput;
import code.elif.webfluxdemo.service.output.CalculationOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CalculatorRequestHandler {

    private final CalculationService calculationService;

    public Mono<ServerResponse> getMultiplication(ServerRequest serverRequest) {
        Mono<CalculationInput> multiplicationInputMono = serverRequest.bodyToMono(CalculationInput.class);
        Mono<CalculationOutput> multiplication = calculationService.multiplication(multiplicationInputMono);
        return ServerResponse.ok()
                .body(multiplication, CalculationOutput.class);
    }

    public Mono<ServerResponse> getAddition(ServerRequest serverRequest) {
        Mono<CalculationInput> multiplicationInputMono = serverRequest.bodyToMono(CalculationInput.class);
        Mono<CalculationOutput> multiplication = calculationService.addition(multiplicationInputMono);
        return ServerResponse.ok()
                .body(multiplication, CalculationOutput.class);
    }

    public Mono<ServerResponse> getDivision(ServerRequest serverRequest) {
        Mono<CalculationInput> multiplicationInputMono = serverRequest.bodyToMono(CalculationInput.class);
        Mono<CalculationOutput> multiplication = calculationService.division(multiplicationInputMono);
        return multiplication.doOnError(
                        throwable ->
                                ServerResponse.badRequest().bodyValue(throwable.getMessage()))
                .flatMap(calculationOutput -> ServerResponse.ok().bodyValue(calculationOutput));
    }

    public Mono<ServerResponse> getSubtraction(ServerRequest serverRequest) {
        Mono<CalculationInput> multiplicationInputMono = serverRequest.bodyToMono(CalculationInput.class);
        Mono<CalculationOutput> multiplication = calculationService.subtraction(multiplicationInputMono);
        return ServerResponse.ok()
                .body(multiplication, CalculationOutput.class);
    }
}
