package code.elif.threads.join;

import java.math.BigInteger;

public class ComplexCalculation {
    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) throws InterruptedException {
        BigInteger result;
        if (base1.compareTo(BigInteger.ZERO) >= 0 &&
                base2.compareTo(BigInteger.ZERO) >= 0 &&
                power1.compareTo(BigInteger.ZERO) >= 0 &&
                power2.compareTo(BigInteger.ZERO) >= 0) {
            PowerCalculatingThread powerCalculatingThread1 = new PowerCalculatingThread(base1, power1);
            PowerCalculatingThread powerCalculatingThread2 = new PowerCalculatingThread(base2, power2);

            powerCalculatingThread1.start();
            powerCalculatingThread2.start();

            powerCalculatingThread1.join();
            powerCalculatingThread2.join();


            result = powerCalculatingThread1.getResult().add(powerCalculatingThread2.getResult());
            return result;
        } else {
            throw new InterruptedException("Unexpected input!");
        }
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }
        }

        public BigInteger getResult() {
            return result;
        }
    }
}