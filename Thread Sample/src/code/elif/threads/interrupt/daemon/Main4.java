package code.elif.threads.interrupt.daemon;

import java.math.BigInteger;

public class Main4 {
    public static void main(String[] args) {
        BlockingThread blockingThread = new BlockingThread();
        System.out.println("Blocking thread initialized...");
        blockingThread.setDaemon(true);
        blockingThread.start();
        System.out.println("Blocking thread started...");
        blockingThread.interrupt();
    }
}

class BlockingThread extends Thread {
    @Override
    public void run() {
        System.out.println(Math.pow(new BigInteger("20000"), new BigInteger("200000")));
    }
}

class Math {
    public static BigInteger pow(BigInteger base, BigInteger pow) {
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ZERO; i.compareTo(pow)!=0;i = i.add(BigInteger.ONE)) {
            result = base.multiply(result) ;
        }
        return result;
    }
}