package code.elif.operators;

import reactor.core.publisher.Flux;

public class OperatorInstance {
    public static void main(String[] args) {
        Flux<Integer> range = Flux.range(1, 10);
        range.map(i -> i * i);
        range.subscribe(i -> System.out.print(i + " ")); //1 2 3 4 5 6 7 8 9 10
    }
}
