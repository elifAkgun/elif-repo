package code.elif.thread.platform;

import code.elif.util.Tasks;

import java.util.concurrent.CountDownLatch;

public class CPUTaskApp {

    public static final int TASK_COUNT = 1;

    public static void main(String[] args) throws InterruptedException {
        demo(Thread.ofPlatform());
    }

    private static void demo(Thread.Builder builder) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(TASK_COUNT);

        for (int i = 0; i < TASK_COUNT; i++) {
            builder.start(() -> {
                Tasks.cpuIntensive(45);
                countDownLatch.countDown();

            });
        }
        countDownLatch.await();
    }
}
