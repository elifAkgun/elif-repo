package code.elif.batch;

import code.elif.ReactiveStreamUtil;
import code.elif.domain.model.Order;
import com.github.javafaker.Commerce;
import com.github.javafaker.Faker;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.function.Function;

public class BatchExample {

    public static final String KIDS = "Kids";
    public static final String AUTOMOTIVE = "Automotive";

    public static void main(String[] args) {

        Map<String, Function<Flux<Order>, Flux<Order>>> map = Map.of(
                KIDS, kidsProcessing(),
                AUTOMOTIVE, automotiveProcessing()
        );

        Flux<Order> orders = getOrders();

        orders.filter(order -> map.containsKey(order.getCategory()))
                .groupBy(order -> order.getCategory())
                .flatMap(stringOrderGroupedFlux ->
                        map.get(stringOrderGroupedFlux.key()).apply(stringOrderGroupedFlux))
                .subscribe(ReactiveStreamUtil.receiveData());
    }


    public static Function<Flux<Order>, Flux<Order>> automotiveProcessing() {
        return flux -> flux
                .doOnNext(p -> {
                            p.setPrice(p.getPrice().multiply(new BigDecimal(1.1)).setScale(2, RoundingMode.UP));
                            p.setItemName("{{ " + p.getItemName() + "1 }}");
                        }
                );
    }

    public static Function<Flux<Order>, Flux<Order>> kidsProcessing() {
        return flux -> flux
                .doOnNext(p ->
                        p.setPrice(p.getPrice().multiply(new BigDecimal(0.5)).setScale(2, RoundingMode.UP))
                )
                .mergeWith(getFreeKidsOrder());
    }

    private static Mono<Order> getFreeKidsOrder() {
        return Mono.fromSupplier(() -> {
            Order order = new Order();
            order.setItemName("FREE EE -" + Faker.instance().commerce().productName());
            order.setPrice(BigDecimal.ZERO);
            order.setCategory("Kids");
            return order;
        });
    }

    private static Flux<Order> getOrders() {
        return Flux.range(1, 1000)
                .map(i -> {
                    Commerce commerce = Faker.instance().commerce();
                    return Order.builder()
                            .category(commerce.department())
                            .itemName(commerce.productName())
                            .price(new BigDecimal(Faker.instance().number().numberBetween(1, 200)))
                            .build();
                });
    }
}
