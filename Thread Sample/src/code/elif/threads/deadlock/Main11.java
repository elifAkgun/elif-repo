package code.elif.threads.deadlock;
import java.util.Random;

public class Main11 {

    public static void main(String[] args) {
        Intersection intersection = new Intersection();

        Thread train1 = new Thread(() -> {
            while (true) {
                Random random = new Random();
                long sleepingTime = random.nextInt(5);
                try {
                    intersection.takeRoadA();
                    Thread.sleep(sleepingTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread train2 = new Thread(() -> {
            while (true) {
                Random random = new Random();
                long sleepingTime = random.nextInt(5);
                try {
                    Thread.sleep(sleepingTime);
                    intersection.takeRoadB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        train1.start();
        train2.start();
    }
}

class Intersection {
    private Object roadA = new Object();
    private Object roadB = new Object();

    public void takeRoadA() throws InterruptedException {
        synchronized (roadA) {
            System.out.println("Road A is locked by " + Thread.currentThread().getName());

            synchronized (roadB) {
                System.out.println("Train is passing through RoadA");
                Thread.sleep(1);
            }
        }
    }

    public void takeRoadB() throws InterruptedException {
        synchronized (roadB) {
            System.out.println("Road B is locked by " + Thread.currentThread().getName());

            synchronized (roadA) {
                System.out.println("Train is passing through RoadB");
                Thread.sleep(1);
            }
        }
    }
}