package code.elif.threads.resourcesharing;

public class Main9 {

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

    private int count;
    private Object lock = new Object();

    public void incrementCount() {
        synchronized (lock) {
            count++;
        }
    }

    public void decrementCount() {
        synchronized (lock) {
            count--;
        }
    }

    public int getCount() {
        synchronized (lock) {
            return count;
        }

    }
}

