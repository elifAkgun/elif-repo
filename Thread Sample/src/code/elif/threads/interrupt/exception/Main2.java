package code.elif.threads.interrupt.exception;

public class Main2 {

    public static void main(String[] args) {
        Thread blockingThread = new Thread(new BlockingThread());
        System.out.println("Blocking thread initialized...");
        blockingThread.start();
        System.out.println("Blocking thread started...");
        blockingThread.interrupt();
    }

}

class BlockingThread implements  Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Thread is interrupted by the other threads...");
        }
    }
}
