package code.elif.thread;

import reactor.core.publisher.Flux;

public class DefaultFluxBehaviour {

    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(integerFluxSink -> {
            printThreadName("Create");
            integerFluxSink.next(1);
        }).doOnNext(i -> printThreadName("Next"));
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + " -> Thread : " + Thread.currentThread().getName());
    }
}
