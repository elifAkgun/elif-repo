package code.elif.operators;

import code.elif.ReactiveStreamUtil;
import reactor.core.publisher.Flux;

public class LimitRate {
    public static void main(String[] args) {
        Flux.range(1, 12)
                .log()
                .limitRate(3)
                .subscribe(ReactiveStreamUtil.receiveData());

    }
}
