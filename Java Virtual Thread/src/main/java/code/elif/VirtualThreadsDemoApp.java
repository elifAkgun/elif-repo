package code.elif;

import code.elif.util.Tasks;

import java.util.concurrent.CountDownLatch;

public class VirtualThreadsDemoApp {

    public static final long THREAD_COUNT = 300_000;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(300000);

        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread.ofVirtual().name("VirtualThreadsDemoApp", i).start(
                    () -> {
                        Tasks.ioIntensive(3);
                        countDownLatch.countDown();
                    }

            );
        }
        countDownLatch.await();
    }
}





