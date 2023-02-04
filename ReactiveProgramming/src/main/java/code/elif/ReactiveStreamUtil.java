package code.elif;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.function.Consumer;

public class ReactiveStreamUtil {

    public static Runnable getCompleted() {
        return () -> System.out.println(
                Thread.currentThread()
                        .getStackTrace()[2]
                        .getMethodName() + " -> Completed");
    }

    public static Consumer<Throwable> getThrowableConsumer() {
        return error -> System.out.println(Thread.currentThread()
                .getStackTrace()[2]
                .getMethodName() + "-> Error: " + error.getMessage());
    }

    public static <T> Consumer<T> getConsumer() {
        return s -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Received : " + s);
        };
    }
}
