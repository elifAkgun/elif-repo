package code.elif.operators;

import code.elif.ReactiveStreamUtil;
import code.elif.domain.model.User;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class SwitchOnFirst {

    public static void main(String[] args) {

        Flux.range(0, 10)
                .map(i -> new User())
                .switchOnFirst((signal, userFlux) ->
                        signal.isOnNext() && signal.get().getAge() > 10
                                ? userFlux : filterData().apply(userFlux))
                .subscribe(ReactiveStreamUtil.receiveData());
    }

    private static Function<Flux<User>, Flux<User>> filterData() {
        return flux -> flux.filter(user -> user.getAge() > 10)
                .doOnNext(user -> user.setName(user.getName().toLowerCase()))
                .doOnDiscard(User.class,
                        user -> System.out.println("Discarded: " + user));
    }
}
