package code.elif.webfluxdemo.controller.api;

import code.elif.webfluxdemo.service.CalculationService;
import code.elif.webfluxdemo.service.input.CalculationInput;
import code.elif.webfluxdemo.service.output.CalculationOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

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
}
