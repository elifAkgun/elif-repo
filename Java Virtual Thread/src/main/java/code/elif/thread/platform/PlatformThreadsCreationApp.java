package code.elif.thread.platform;

import code.elif.util.Tasks;

import java.util.concurrent.CountDownLatch;

/**
 * Hello world!
 */
public class PlatformThreadsCreationApp {
    public static final String THREAD = "Thread ";
    private static final int MAX_PLATFORM = 10;

    public static void main(String[] args) throws InterruptedException {
        platformThreadCreation3();
    }

    private static void platformThreadCreation() {
        for (int i = 0; i < MAX_PLATFORM; i++) {
            int j = i;
            Thread thread = new Thread(() -> Tasks.ioIntensive(j, THREAD + j));
            thread.start();
        }
    }

    private static void platformThreadCreation2() {
        for (int i = 0; i < MAX_PLATFORM; i++) {
            int j = i;
            Thread.Builder.OfPlatform ofPlatform = Thread.ofPlatform().name("Platform " + j, i);
            Thread thread = ofPlatform.unstarted(() -> Tasks.ioIntensive(j, THREAD + j));
            thread.start();
        }
    }

    private static void platformThreadCreation3() throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 0; i < MAX_PLATFORM; i++) {
            int j = i;
            Thread.Builder.OfVirtual platform = Thread.ofVirtual()
                    .name("Platform", i);
            Thread thread = platform.unstarted(() -> {
                Tasks.ioIntensive(j, THREAD + j);
                countDownLatch.countDown();
            });
            thread.start();
        }
        countDownLatch.await();
    }
}