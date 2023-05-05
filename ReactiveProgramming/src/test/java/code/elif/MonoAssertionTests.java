package code.elif;

import code.elif.domain.model.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.Duration;

public class MonoAssertionTests {

    // JUnit test for
    @DisplayName("Test using assertion")
    @Test
    public void given_when_then() {
        // given- precondition or setup
        Mono<Order> orderServiceMono = Mono.fromSupplier(() ->
                Order.builder().category("category")
                        .price(new BigDecimal(1))
                        .itemName("book")
                        .build()
        ).delayElement(Duration.ofSeconds(3));

        // when - action or the behaviour that we are going test

        // then - verify the output
        StepVerifier.create(orderServiceMono)
                .assertNext(order -> Assertions.assertNotNull(order.getCategory()))
                .expectComplete()
                .verify(Duration.ofSeconds(4));

    }
}
