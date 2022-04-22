package code.elif.iteration;

public class FactorialCalculation {

    public static void main(String[] args) {
        // n! = n * (n-1) * (n-2) * ... * 2 * 1
        long n = 7;
        long value = calculate(n);
        System.out.println(value);
    }

    private static long calculate(long n) {
        if (n == 1) {
            return 1;
        }
        return calculate(n-1) * n;
    }
}
