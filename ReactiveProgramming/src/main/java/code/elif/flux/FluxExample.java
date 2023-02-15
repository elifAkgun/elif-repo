package code.elif.flux;

import code.elif.ReactiveStreamUtil;
import reactor.core.publisher.Flux;

public class FluxExample {

    public static void main(String[] args) {
        Flux.just(1,2,3,4,5)
                .subscribe(ReactiveStreamUtil.receiveData(),
                        ReactiveStreamUtil.handleError(),
                        ReactiveStreamUtil.complete());
    }
}
