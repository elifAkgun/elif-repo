package code.elif.threads.conditionvariables;

import java.util.concurrent.locks.Lock;

public class Main18 {
}

class SimpleCountDownLatch {
    private int count;
    private Object lock = new Object();

    public SimpleCountDownLatch(int count) {
        this.count = count;
        if (count < 0) {
            throw new IllegalArgumentException("count cannot be negative");
        }
    }

    /**
     * Causes the current thread to wait until the latch has counted down to zero.
     * If the current count is already zero then this method returns immediately.
     */
    public void await() throws InterruptedException {
        if (count == 0)
            return;
        while (count != 0) {
            await();
        }
    }

    /**
     * Decrements the count of the latch, releasing all waiting threads if the count reaches zero.
     * If the current count equals zero then nothing happens.
     */
    public void countDown() {
        if (count == 0)
            notifyAll();
    }

    /**
     * Returns the current count.
     */
    public int getCount() {
        synchronized (lock) {
            return count;
        }
    }
}

