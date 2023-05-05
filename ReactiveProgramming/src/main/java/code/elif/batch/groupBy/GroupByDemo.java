package code.elif.batch.groupBy;

import code.elif.ReactiveStreamUtil;
import code.elif.domain.model.BookOrder;
import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;

public class GroupByDemo {

    public static void main(String[] args) {
        getBookOrders()
                .groupBy(bookOrder ->
                        bookOrder.getBook().genre()
                )
                .subscribe(groupedFlux -> {
                    System.out.println(groupedFlux.key());
                    groupedFlux.subscribe(ReactiveStreamUtil.receiveData());
                });
    }

    private static Flux<BookOrder> getBookOrders() {
        return Flux.range(1, 10)
                .map(i -> BookOrder.builder()
                        .book(Faker.instance().book())
                        .price(Faker.instance().number().numberBetween(1, 10))
                        .build());
    }
}
