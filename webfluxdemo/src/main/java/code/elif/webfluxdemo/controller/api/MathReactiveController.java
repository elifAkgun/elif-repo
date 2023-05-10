package code.elif.webfluxdemo.controller.api;

import code.elif.webfluxdemo.exception.InputValidationException;
import code.elif.webfluxdemo.service.MathReactiveService;
import code.elif.webfluxdemo.service.output.MultiplicationTableOutput;
import code.elif.webfluxdemo.service.output.SquareOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
}
