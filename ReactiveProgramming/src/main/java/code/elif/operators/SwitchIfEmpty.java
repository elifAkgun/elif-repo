package code.elif.operators;

import code.elif.ReactiveStreamUtil;
import reactor.core.publisher.Flux;

public class SwitchIfEmpty {
    public static void main(String[] args) {
        getNumbers()
                .filter(i -> i > 10)
                .switchIfEmpty(getLargeNumbers())
                .subscribe(ReactiveStreamUtil.receiveData());
    }

    private static Flux<Integer> getNumbers() {
        return Flux.range(1, 10); //start at 1, produce 10 item
    }

    private static Flux<Integer> getLargeNumbers() {
        return Flux.range(10, 50); //start at 10, produce 50 item
    }
}
