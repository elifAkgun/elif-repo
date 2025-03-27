package code.elif;

import code.elif.util.Tasks;

import java.util.concurrent.CountDownLatch;

public class CPUTaskDemo {

    public static final int TASK_COUNT = 1;

    public static void main(String[] args) {

        demo(Thread.ofVirtual());
    }

    private static void demo(Thread.Builder builder) {
        CountDownLatch countDownLatch = new CountDownLatch(TASK_COUNT);

        for (int i = 0; i < TASK_COUNT; i++) {
            builder.start(() -> {
                Tasks.cpuIntensive(45);
                countDownLatch.countDown();

            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
