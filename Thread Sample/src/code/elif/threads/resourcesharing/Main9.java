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

class MinMaxMetrics {

    // Add all necessary member variables
    private volatile long min;
    private volatile long max;
    /**
     * Initializes all member variables
     */
    public MinMaxMetrics() {
        // Add code here
        min = Long.MAX_VALUE;
        max = Long.MIN_VALUE;
    }

    /**
     * Adds a new sample to our metrics.
     */
    public synchronized void addSample(long newSample) {
        if(newSample<min){
            min=newSample;
        } else if (newSample>max){
            max = newSample;
        }
    }


    /**
     * Returns the smallest sample we've seen so far.
     */
    public long getMin() {
        // Add code here
        return min;
    }

    /**
     * Returns the biggest sample we've seen so far.
     */
    public long getMax() {
        // Add code here
        return max;
    }
}
