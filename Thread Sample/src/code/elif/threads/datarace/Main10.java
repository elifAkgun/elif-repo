package code.elif.threads.datarace;

public class Main10 {

    public static void main(String[] args) throws InterruptedException {
        SharedClass sharedClass1 = new SharedClass();

        Thread thread1 = new Thread(() -> {
            while (true) {
                sharedClass1.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                try {
                    sharedClass1.checkDataRaceCondition();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

    }
}

class SharedClass {
    int x;
    int y;

    public void increment() {
        x++;
        y++;
    }

    public void checkDataRaceCondition() throws Exception {
        if (y > x)
            throw new Exception("This should not be possible!");
    }

}