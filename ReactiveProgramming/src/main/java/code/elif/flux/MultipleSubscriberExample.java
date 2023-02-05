package code.elif.flux;

import reactor.core.publisher.Flux;

public class MultipleSubscriberExample {

    public static void main(String[] args) {
        Flux<Integer> numbers = Flux.just(1, 2, 3, 4, 5);

        Flux<Integer> evenNumbers = numbers.filter(i -> i % 2 == 0);
        Flux<Integer> oddNumbers = numbers.filter(i -> i % 2 == 1);

        evenNumbers.subscribe(i -> System.out.println("first subscriber received -> " + i));
        oddNumbers.subscribe(i -> System.out.println("second subscriber received -> " + i));
    }

}
