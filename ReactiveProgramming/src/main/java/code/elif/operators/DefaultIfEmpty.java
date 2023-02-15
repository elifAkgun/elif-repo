package code.elif.operators;

import code.elif.ReactiveStreamUtil;
import reactor.core.publisher.Flux;

public class DefaultIfEmpty {

    public static void main(String[] args) {
        getNumbers()
                .filter(number -> number > 10)
                .defaultIfEmpty(-1)
                .subscribe(ReactiveStreamUtil.receiveData());
    }

    private static Flux<Integer> getNumbers() {
        return Flux.range(1, 10);
    }

}
