package code.elif.app.funcInterface.consumer;

import code.elif.app.funcInterface.model.User;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Consumer;

public class ConsumerTest {

    public static void main(String[] args) {
       // runConsumer();
        runConsumerChain();
    }

    private static void runConsumer() {
        Consumer<User> consumer = u -> {
            System.out.println("User Name " + u.getUserName());
            System.out.println("Password " +  StringUtils.repeat('*', u.getPassword().length()));
        };

        consumer.accept(new User("John", "12345"));
    }

    private static void runConsumerChain() {
        Consumer<User> consumer1 = u -> {
            System.out.println("User Name " + u.getUserName());
        };
        Consumer<User> consumer2 = u -> {
            System.out.println("Password " +  StringUtils.repeat('*', u.getPassword().length()));
        };

        consumer1.andThen(consumer2).accept(new User("John", "12345"));
    }
}
