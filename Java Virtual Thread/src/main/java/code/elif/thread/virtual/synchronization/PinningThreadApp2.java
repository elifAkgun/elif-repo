package code.elif.thread.virtual.synchronization;

public class PinningThreadApp2 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("jdk.tracePinnedThreads", "full");

        Runnable task = () -> {
            synchronized (PinningThreadApp.class) {
                try {
                    Thread.sleep(5000); // I/O benzeri bir işlem
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread.startVirtualThread(task);
        Thread.sleep(1000); //uygulamanın aniden kapanmaması için

    }
}
