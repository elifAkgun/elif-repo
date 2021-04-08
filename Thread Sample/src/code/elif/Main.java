package code.elif;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final int MAX_PASS = 1000;

    public static void main(String[] args) {

        Vault vault = new Vault(new Random().nextInt(MAX_PASS));

        HackerThread hackerThread1 = new AscendingHackerThread(vault);
        HackerThread hackerThread2 = new DescendingHackerThread(vault);
        PoliceThread policeThread = new PoliceThread();

        List<Thread> threads = new ArrayList<>();

        threads.add(hackerThread1);
        threads.add(hackerThread2);
        threads.add(policeThread);

        for (Thread t : threads) {
            t.start();
        }

        System.out.println(vault.password + " is the password...");

    }

    public static class Vault {
        private int password;

        public Vault(int password) {
            this.password = password;
        }

        public boolean isCorrectPassword(int guess) {
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return password == guess;
        }


    }

    public static abstract class HackerThread extends Thread {
        protected Vault vault;

        public HackerThread(Vault vault) {
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
        }
    }

    private static class AscendingHackerThread extends HackerThread {

        public AscendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public synchronized void start() {
            System.out.println(this.getClass().getSimpleName());
            super.start();
        }

        @Override
        public void run() {
            for (int i = 0; i < MAX_PASS; i++) {
                if (vault.isCorrectPassword(i)) {
                    System.out.println("The password (" + i + ") has been hacked by " + this.getClass().getSimpleName());
                    System.exit(0);
                }
            }
        }
    }

    private static class DescendingHackerThread extends HackerThread {

        public DescendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public synchronized void start() {
            System.out.println(this.getClass().getSimpleName());
            super.start();
        }

        @Override
        public void run() {
            for (int i = MAX_PASS; i > 0; i--) {
                if (vault.isCorrectPassword(i)) {
                    System.out.println("The password (" + i + ") has been hacked by " + this.getClass().getSimpleName());
                    System.exit(0);
                }
            }
        }
    }

    private static class PoliceThread extends Thread {
        @Override
        public synchronized void start() {
            System.out.println("Police has started to search...");
            this.setName(this.getClass().getSimpleName());
            super.start();
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(this.getClass().getSimpleName() + "said that \"Game over guys!!\"");
            System.exit(0);
        }
    }

}

