package code.elif.domain.service.impl;

import code.elif.domain.service.BaseServiceImpl;
import code.elif.domain.service.OrderService;
import code.elif.domain.service.data.DataProvider;
import code.elif.domain.model.Order;
import reactor.core.publisher.Flux;

public class OrderServiceImpl extends BaseServiceImpl implements OrderService {

    public OrderServiceImpl(DataProvider dataProvider) {
        super(dataProvider);
    }

    @Override
    public Flux<Order> getOrders(String userId) {
        return Flux.create(fluxSink -> {
            dataProvider.getOrderMap().get(userId).forEach(fluxSink::next);
            fluxSink.complete();
        });
    }
}
