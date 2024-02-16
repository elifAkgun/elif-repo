package code.elif.webfluxdemo.controller.api;

import code.elif.webfluxdemo.service.MathReactiveService;
import code.elif.webfluxdemo.service.output.MultiplicationTableOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/math-reactive")
@Slf4j
public class MathReactiveController {

    private final MathReactiveService mathReactiveService;

    @GetMapping(value = "/multiplicationTable/stream/{input}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MultiplicationTableOutput> getMultiplicationTableWithEventStream(@PathVariable("input") Integer number) {
        return mathReactiveService.getMultiplicationTable(number);
    }

    @GetMapping(value = "/multiplicationTable/{input}")
    public Flux<MultiplicationTableOutput> getMultiplicationTable(@PathVariable("input") Integer number) {
        return mathReactiveService.getMultiplicationTable(number);
    }
}
