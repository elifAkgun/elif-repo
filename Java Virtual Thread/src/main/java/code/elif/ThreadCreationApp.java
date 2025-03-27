package code.elif;

import com.sun.tools.javac.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadFactory;

public class ThreadCreationApp {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {

        // Geleneksel yönteme göre (daha karmaşık görünür)
        ThreadFactory factory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "worker-thread-with-factory");
            }
        };
        Thread thread = factory.newThread(() ->
                logger.info("Hello, platorm thread!"));
        thread.start();

        // Builder ile
        Thread.ofPlatform().name("worker-thread-virtual").start(() ->
                logger.info("Hello, virtual thread!"));

        Thread.ofVirtual().start(() -> logger.info("Simple virtual thread"));

        Thread.ofVirtual()
                .name("custom-thread", 0)
                .start(() -> logger.info("Customized virtual thread"));

        Thread.sleep(2000);

    }
}