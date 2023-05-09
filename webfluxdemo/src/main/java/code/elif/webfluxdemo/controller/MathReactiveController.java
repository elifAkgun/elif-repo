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
