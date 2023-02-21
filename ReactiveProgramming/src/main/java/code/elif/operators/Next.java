package code.elif.operators;

import reactor.core.publisher.Flux;

public class Next {

    public static void main(String[] args) {
        Flux.range(1, 10)
                .next()
                .subscribe(System.out::println);
    }
}
