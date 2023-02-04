package code.elif.mono;

import reactor.core.publisher.Mono;

public class MonoFromRunnable {

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Runnable started.");

        Mono.fromRunnable(runnable)
                .subscribe(r -> System.out.println(r),
                        error -> System.out.println(error),
                        () -> System.out.println("Completed.."));
    }
}
