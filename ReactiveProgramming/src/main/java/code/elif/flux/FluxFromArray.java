package code.elif.flux;

import code.elif.ReactiveStreamUtil;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class FluxFromArray {
    public static void main(String[] args) {
        Integer array[] = {1, 2, 3, 4, 5};
        Flux<Object> numbers = Flux.fromArray(array);
        numbers.subscribe(ReactiveStreamUtil.getConsumer());
    }
}
