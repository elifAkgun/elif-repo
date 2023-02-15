package code.elif;

import java.util.function.Consumer;

public class ReactiveStreamUtil {

    public static Runnable complete() {
        return () -> System.out.println(Thread.currentThread()
                .getStackTrace()[2].getMethodName() + " -> Completed");
    }

    public static Consumer<Throwable> handleError() {
        return error -> System.out.println(Thread.currentThread()
                .getStackTrace()[2]
                .getMethodName() + "-> Error: " + error.getMessage());
    }

    public static <T> Consumer<T> receiveData() {
        return s -> System.out.println(Thread.currentThread()
                .getStackTrace()[2].getMethodName() +"-> Received : " + s);
    }
}
