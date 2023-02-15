package code.elif.operators;

import reactor.core.publisher.Flux;

public class HandleOperatorExample {

    public static void main(String[] args) {
        Flux.range(0, 10)
                .handle((number, synchronousSink) -> {
                    if (number % 2 == 0)
                        synchronousSink.next(number);
                })
                .subscribe(number -> System.out.println("Received : " + number));
    }
}
