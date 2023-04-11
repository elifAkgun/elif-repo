package code.elif.thread.single;

import reactor.core.publisher.Flux;

public class DefaultFluxBehaviourWithMultipleThread {

    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(integerFluxSink -> {
            printThreadName("Create");
            integerFluxSink.next(1);
        }).doOnNext(i -> printThreadName("Next"));

        Runnable r = () -> flux.subscribe(data -> printThreadName("Subscription - Data: " + data));

        for (int i = 0; i < 2; i++) {
            new Thread(r).start();
        }
    }

    private static void printThreadName(String msg) {
        System.out.println(msg + " -> Thread : " + Thread.currentThread().getName());
    }
}

