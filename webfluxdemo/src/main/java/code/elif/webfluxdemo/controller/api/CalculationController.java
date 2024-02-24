package code.elif.webfluxdemo.controller.api;

import code.elif.webfluxdemo.exception.InputValidationException;
import code.elif.webfluxdemo.service.CalculationService;
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
@RequestMapping("/calculator")
@Slf4j
public class CalculationController {

    private final CalculationService calculationService;

    @PostMapping(value = "/multiplication", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<CalculationOutput> multiplication(@RequestBody Mono<CalculationInput> input,
                                                  @RequestHeader Map<String, String> headers) {
        log.info(headers.toString());
        return calculationService.multiplication(input);
    }

    @PostMapping(value = "/addition", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<CalculationOutput> addition(@RequestBody Mono<CalculationInput> input,
                                                  @RequestHeader Map<String, String> headers) {
        log.info(headers.toString());
        return calculationService.addition(input);
    }

    @PostMapping(value = "/division", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<CalculationOutput> division(@RequestBody Mono<CalculationInput> input,
                                                  @RequestHeader Map<String, String> headers) {
        log.info(headers.toString());
        return calculationService.division(input);
    }

    @PostMapping(value = "/subtraction", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<CalculationOutput> subtraction(@RequestBody Mono<CalculationInput> input,
                                                  @RequestHeader Map<String, String> headers) {
        log.info(headers.toString());
        return calculationService.subtraction(input);
    }

    @GetMapping("/square/{input}")
    public Mono<SquareOutput> square(@PathVariable("input") Integer number) {
        if (number < 1 || number > 20)
            throw new InputValidationException(BigDecimal.valueOf(number), "Number should be between 1-20");

        return calculationService.square(number);
    }

    @GetMapping("/square2/{input}")
    public Mono<SquareOutput> squareReactivePipelineErrorHandling(@PathVariable("input") Integer number) {
        return Mono.just(number)
                .handle((integer, synchronousSink) -> {
                    if (integer >= 1 && integer <= 20) {
                        synchronousSink.next(integer);
                    } else {
                        synchronousSink.error(new InputValidationException(number, "Number should be between 1-20"));
                    }
                }).cast(Integer.class)
                .flatMap(calculationService::square);
    }

    @GetMapping("/square3/{input}")
    public Mono<ResponseEntity<Mono<SquareOutput>>> squareReactivePipelineBadRequest(@PathVariable("input") Integer number) {
        return Mono
                .just(number)
                .filter(i -> i >= 10 && i <= 20)
                .map(calculationService::square)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }
}
