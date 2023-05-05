package code.elif.sink;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class SinkWithError {

    public static void main(String[] args) throws InterruptedException {

        Sinks.One<Object> sink = Sinks.one();

        Mono<Object> objectMono = sink.asMono();

        objectMono
                .onErrorReturn("Error occurred")
                .onErrorResume(error -> {
                    System.err.println("Error occurred: " + error.getMessage());
                    return Mono.empty();
                })
                .subscribe(System.out::println);

        sink
                .emitValue(getValue(), (signalType, emitResult) -> {
                    System.out.println(signalType.name());
                    System.out.println(emitResult.name());
                    return true;
                });

        Thread.sleep(2000);
    }

    private static Object getValue() {
        try {
            return 1 / 0;
        }
        catch (ArithmeticException ex) {
            System.err.println("Error happened!");
        }
        finally {
            return 0;
        }
    }
}