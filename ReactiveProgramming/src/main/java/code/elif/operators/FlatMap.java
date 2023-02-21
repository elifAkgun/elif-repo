package code.elif.operators;

import code.elif.ReactiveStreamUtil;
import code.elif.domain.service.OrderService;
import code.elif.domain.service.UserService;
import code.elif.domain.service.data.DataProvider;
import code.elif.domain.service.impl.OrderServiceImpl;
import code.elif.domain.service.impl.UserServiceImpl;

public class FlatMap {

    public static void main(String[] args) {

        DataProvider dataProvider = new DataProvider();
        OrderService orderService = new OrderServiceImpl(dataProvider);
        UserService userService = new UserServiceImpl(dataProvider);

        userService.getUsers()
                .flatMap(user -> orderService.getOrders(user.getId()))
                .subscribe(ReactiveStreamUtil.receiveData());

    }
}
