package code.elif.domain.service;

import code.elif.domain.model.User;
import reactor.core.publisher.Flux;

public interface UserService {

    Flux<User> getUsers();
}
