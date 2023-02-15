package code.elif;

import java.util.function.Consumer;

public class ReactiveStreamUtil {

    public static Runnable getCompleted() {
        return () -> System.out.println(Thread.currentThread()
                .getStackTrace()[2].getMethodName() + " -> Completed");
    }

    public static Consumer<Throwable> getThrowableConsumer() {
        return error -> System.out.println(Thread.currentThread()
                .getStackTrace()[2]
                .getMethodName() + "-> Error: " + error.getMessage());
    }

    public static <T> Consumer<T> getConsumer() {
        return s -> System.out.println(Thread.currentThread()
                .getStackTrace()[2].getMethodName() +"-> Received : " + s);
    }
}
