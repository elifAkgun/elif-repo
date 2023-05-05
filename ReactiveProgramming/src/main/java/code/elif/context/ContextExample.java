package code.elif.context;

import reactor.core.publisher.Mono;
import reactor.util.context.Context;

public class ContextExample {

    public static void main(String[] args) {
        Mono<String> mono = getWelcomeMessage()
                .contextWrite(Context.of("userId", "sam"));

        mono.subscribe(msg -> System.out.println(msg));
    }

    private static Mono<String> getWelcomeMessage() {
        return Mono.deferContextual(contextView ->
                contextView.hasKey("userId") ? Mono.just("Hello " + contextView.get("userId"))
                        : Mono.error(new RuntimeException("UnAuthentication user!"))
        );

    }
}
