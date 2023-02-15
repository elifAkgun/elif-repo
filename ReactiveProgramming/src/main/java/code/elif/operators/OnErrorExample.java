package code.elif.operators;

import code.elif.ReactiveStreamUtil;
import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class OnErrorExample {

    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .map(integer -> 10 / (5 - integer)) //causes exception
                //   .onErrorReturn(-1)
                //  .onErrorResume((throwable) -> fallBack())
                .onErrorContinue((e, o) -> System.out.println("Error happened when emitting : " + o + " -> " + e))
                .subscribe(ReactiveStreamUtil.receiveData());
    }

    public static Mono<Integer> fallBack() {
        return Mono.fromSupplier(() -> Faker.instance().random().nextInt(1, 10));
    }
}
