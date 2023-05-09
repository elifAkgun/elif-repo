package code.elif.webfluxdemo.controller;

import code.elif.webfluxdemo.exception.InputValidationException;
import code.elif.webfluxdemo.service.MathReactiveService;
import code.elif.webfluxdemo.service.input.MultiplicationInput;
import code.elif.webfluxdemo.service.output.MultiplicationOutput;
import code.elif.webfluxdemo.service.output.MultiplicationTableOutput;
import code.elif.webfluxdemo.service.output.SquareOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/math-reactive")
@Slf4j
public class MathReactiveController {

    private final MathReactiveService mathReactiveService;

    @GetMapping("/square/{input}")
    public Mono<SquareOutput> square(@PathVariable("input") Integer number) {
        if (number < 1 || number > 20)
            throw new InputValidationException(number);

        return mathReactiveService.square(number);
    }

    @GetMapping("/square2/{input}")
    public Mono<SquareOutput> squareReactivePipelineErrorHandling(@PathVariable("input") Integer number) {
        return Mono.just(number)
                .handle((integer, synchronousSink) -> {
                    if (integer >= 1 && integer <= 20) {
                        synchronousSink.next(integer);
                    } else {
                        synchronousSink.error(new InputValidationException(number));
                    }
                }).cast(Integer.class)
                .flatMap(integer -> mathReactiveService.square(integer));
    }

    @GetMapping("/square3/{input}")
    public Mono<ResponseEntity<SquareOutput>> squareReactivePipelineBadRequest(@PathVariable("input") Integer number) {
        return Mono.just(number)
                .filter(i -> i >= 10 && i <= 20)
                .flatMap(i -> mathReactiveService.square(i))
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @GetMapping(value = "/multiplicationTable/{input}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MultiplicationTableOutput> getMultiplicationTable(@PathVariable("input") Integer number) {
        return mathReactiveService.getMultiplicationTable(number);
    }

    @PostMapping(value = "/multiplication", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<MultiplicationOutput> multiplication(@RequestBody Mono<MultiplicationInput> input,
                                                     @RequestHeader Map<String, String> headers) {
        log.info(headers.toString());
        return mathReactiveService.getMultiplication(input);
    }
}
