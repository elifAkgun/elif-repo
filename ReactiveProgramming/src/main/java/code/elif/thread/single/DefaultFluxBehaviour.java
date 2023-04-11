package code.elif.thread.single;

import reactor.core.publisher.Flux;

public class DefaultFluxBehaviour {

    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(integerFluxSink -> {
            printThreadName("Create");
            integerFluxSink.next(1);
        }).doOnNext(i -> printThreadName("Next"));

        flux.subscribe(v -> printThreadName("Sub : " + v));
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + " -> Thread : " + Thread.currentThread().getName());
    }
}
