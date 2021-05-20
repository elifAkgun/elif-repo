package code.elif.threads.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Main16 {

    public static void main(String[] args) throws InterruptedException {
        InventoryCounter inventoryCounter = new InventoryCounter();

        Thread increment = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                inventoryCounter.incrementCount();
            }
        });

        Thread decrement = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                inventoryCounter.decrementCount();
            }
        });

        increment.start();
        decrement.start();

        increment.join();
        decrement.join();

        System.out.println(inventoryCounter.getCount());
    }
}

class InventoryCounter {

    private AtomicInteger countAtomic = new AtomicInteger(0);

    public void incrementCount() {
        countAtomic.incrementAndGet();
    }

    public void decrementCount() {
        countAtomic.decrementAndGet();
    }

    public int getCount() {
      return countAtomic.get();
    }
}