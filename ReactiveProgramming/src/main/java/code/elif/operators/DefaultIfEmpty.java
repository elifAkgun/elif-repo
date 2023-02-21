package code.elif.operators;

import reactor.core.publisher.Flux;

public class DefaultIfEmpty {

    public static void main(String[] args) {
        getNumbers()
                .filter(number -> number > 10)
                .defaultIfEmpty(-1)
                .subscribe(s -> System.out.println(Thread.currentThread()
                        .getStackTrace()[2].getMethodName() +"() -> Received : " + s));
    }

    private static Flux<Integer> getNumbers() {
        return Flux.range(1, 10);
    }
}