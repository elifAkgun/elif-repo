package code.elif.iteration;

public class FibonacciCalculation {

    public static void main(String[] args) {
        int n = 10;
        // result = n + (n-1) + (n-2) + (n-3) + ... +
        int result = calculate (n);
        System.out.println(result);
    }

    private static int calculate(int n) {
        if(n == 1)
            return 1;
        return calculate(n-1) + n;
    }
}
