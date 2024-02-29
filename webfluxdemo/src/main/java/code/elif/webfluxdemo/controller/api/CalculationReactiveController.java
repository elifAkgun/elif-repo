package code.elif.webfluxdemo.controller.api;

import code.elif.webfluxdemo.exception.InputValidationException;
import code.elif.webfluxdemo.service.CalculationReactiveService;
import code.elif.webfluxdemo.service.input.CalculationInput;
import code.elif.webfluxdemo.service.output.CalculationOutput;
import code.elif.webfluxdemo.service.output.SquareOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reactive-calculator")
@Slf4j
public class CalculationReactiveController {

    private final CalculationReactiveService calculationReactiveService;

    @PostMapping(value = "/multiplication", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<CalculationOutput> multiplication(@RequestBody Mono<CalculationInput> input,
                                                  @RequestHeader Map<String, String> headers) {
        log.info(headers.toString());
        return calculationReactiveService.multiplication(input);
    }

    @PostMapping(value = "/addition", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<CalculationOutput> addition(@RequestBody Mono<CalculationInput> input,
                                            @RequestHeader Map<String, String> headers) {
        log.info(headers.toString());
        return calculationReactiveService.addition(input);
    }

    @PostMapping(value = "/division", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<CalculationOutput> division(@RequestBody Mono<CalculationInput> input,
                                            @RequestHeader Map<String, String> headers) {
        log.info(headers.toString());
        return calculationReactiveService.division(input);
    }

    @PostMapping(value = "/subtraction", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<CalculationOutput> subtraction(@RequestBody Mono<CalculationInput> input,
                                               @RequestHeader Map<String, String> headers) {
        log.info(headers.toString());
        return calculationReactiveService.subtraction(input);
    }

    @GetMapping(value = "/square/{input}")
    public Mono<SquareOutput> square(@PathVariable("input") Integer number) {
        if (number < 1 || number > 20)
            throw new InputValidationException(BigDecimal.valueOf(number), "Number should be between 1-20");

        return calculationReactiveService.square(number);
    }

    @GetMapping("/pipeline/square/{input}")
    public Mono<SquareOutput> squareReactivePipelineErrorHandling(@PathVariable("input") Integer number) {
        return Mono.just(number)
                .handle((integer, synchronousSink) -> {
                    if (integer >= 1 && integer <= 20) {
                        synchronousSink.next(integer);
                    } else {
                        synchronousSink.error(new InputValidationException(number, "Number should be between 1-20"));
                    }
                }).cast(Integer.class)
                .flatMap(calculationReactiveService::square);
    }

    @GetMapping("/filter/square/{input}")
    public Mono<ResponseEntity<SquareOutput>> squareReactivePipelineBadRequest(@PathVariable("input") Integer number) {

        return Mono
                .just(number)
                .filter(i -> i >= 10 && i <= 20)
                .flatMap(i -> calculationReactiveService.square(i)
                        .map(ResponseEntity::ok))
                .switchIfEmpty(Mono.just(ResponseEntity.badRequest().build()));
    }
}
