package code.elif.interceptor;

public class PrimeGenerator {

    private static boolean[] crossedOut;
    private static int result[];

    public static int[] generatePrimes(int maxValue) {

        if (maxValue < 2) {
            return new int[0];

        } else {
            uncrossIntegersUpTo(maxValue);
            crossOutMultiples();
            putUncrossedIntegersToResult();
            return result;
        }
    }
    private static void uncrossIntegersUpTo(int maxValue) {
        crossedOut = new boolean[maxValue + 1];
    }

    private static void crossOutMultiples() {
        int maxPrimeFactor = determineIterationLimit();
        for (int i = 2; i <= maxPrimeFactor; i++) {
            if (notCrossed(i)) {
                crossOutMultiplesOf(i);
            }
        }
    }

    private static void crossOutMultiplesOf(int i) {
        for (int multiple = 2 * i;
             multiple < crossedOut.length;
             multiple += i) {
            crossedOut[multiple] = true;
        }
    }

    private static boolean notCrossed(int i) {
        return crossedOut[i] == false;
    }

    private static void putUncrossedIntegersToResult() {

        result = new int[numberOfUnCrossedIntegers()];

        for (int i = 2, j = 0; i < crossedOut.length; i++) {
            if (notCrossed(i))
                result[j++] = i;
        }
    }

    private static int numberOfUnCrossedIntegers() {
        int count = 0;
        for (int i = 2; i < crossedOut.length; i++) {
            if (notCrossed(i))
                count++;
        }
        return count;
    }

    private static int determineIterationLimit() {
        double maxPrimeFactor = Math.sqrt(crossedOut.length) ;
        return (int) maxPrimeFactor;
    }
}
