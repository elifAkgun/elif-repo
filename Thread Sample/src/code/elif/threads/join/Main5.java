package code.elif.threads.join;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main5 {

    public static void main(String[] args) throws InterruptedException {
        List<Long> factorialNumbers = Arrays.asList(1L, 534234324L, 123L);
        List<FactorialThread> factorialThreads = new ArrayList<>();

        for (Long number : factorialNumbers) {
            factorialThreads.add(new FactorialThread(number));
        }

        for (FactorialThread factorialThread : factorialThreads) {
            factorialThread.setDaemon(true);
            factorialThread.start();
        }
        for (FactorialThread factorialThread : factorialThreads) {
            factorialThread.join(2000);
        }

        for (FactorialThread factorialThread : factorialThreads) {
            if (factorialThread.isFinished()) {
                System.out.println(factorialThread.getNumber()
                        + " is finished. The result is "
                        + factorialThread.getResult());
            }
            else {
                System.out.println(factorialThread.getNumber()
                        + " is in progress.");
            }
        }
    }
}


class FactorialThread extends Thread {
    private long number;
    private BigInteger result;
    private boolean finished;

    FactorialThread(long number) {
        this.number = number;
    }

    @Override
    public void run() {
        factorial(number);
        finished = true;
    }

    private void factorial(long input) {
        result = BigInteger.ONE;
        for (long i = 1; i <= input; i++) {
            result = result.multiply(new BigInteger(Long.toString(i)));
        }
    }

    public BigInteger getResult() {
        return result;
    }

    public boolean isFinished() {
        return finished;
    }


    public long getNumber() {
        return number;
    }
}