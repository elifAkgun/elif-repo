package code.elif.threads.interrupt.checkingsignal;

import java.math.BigInteger;

public class Main3 {
    public static void main(String[] args) {
        BlockingThread blockingThread = new BlockingThread();
        System.out.println("Blocking thread initialized...");
        blockingThread.start();
        System.out.println("Blocking thread started...");
        blockingThread.interrupt();
    }
}

class BlockingThread extends Thread {
    @Override
    public void run() {
        System.out.println(Math.pow(new BigInteger("20000"), new BigInteger("2000")));
    }
}

class Math {
    public static BigInteger pow(BigInteger base, BigInteger pow) {
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ZERO; i.compareTo(pow)!=0;i = i.add(BigInteger.ONE)) {
            if(Thread.interrupted()){
                System.out.println("Thread is interrupted by the other threads...");
                return BigInteger.ZERO;
            }
            result = base.multiply(result) ;
        }
        return result;
    }
}