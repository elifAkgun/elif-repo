package code.elif.domain.service.impl;

import code.elif.domain.model.User;
import code.elif.domain.service.BaseServiceImpl;
import code.elif.domain.service.UserService;
import code.elif.domain.service.data.DataProvider;
import reactor.core.publisher.Flux;

public class UserServiceImpl extends BaseServiceImpl implements UserService {

    public UserServiceImpl(DataProvider dataProvider) {
        super(dataProvider);
    }

    @Override
    public Flux<User> getUsers() {
        return Flux.create(userFluxSink -> {
            dataProvider.getUserList().forEach(userFluxSink::next);
            userFluxSink.complete();
        });
    }
}
