package code.elif.domain.service;

import code.elif.domain.model.Order;
import reactor.core.publisher.Flux;

public interface OrderService {

    Flux<Order> getOrders(String userId);
}
