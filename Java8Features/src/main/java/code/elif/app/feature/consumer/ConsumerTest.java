package code.elif.app.feature.consumer;

import code.elif.app.feature.model.User;

import java.util.function.Consumer;

public class ConsumerTest {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Consumer<User> consumer = u -> System.out.println("User Name" + u.toString());
    }
}
