package code.elif.recursion;

public class Recursive {

    public static void main(String[] args) {
        int fibonacci = fibonacci(9);
        System.out.println(fibonacci);

        int factorial = factorial(5);
        System.out.println(factorial);
    }

    private static int fibonacci(int x) {
        if (x <= 2) {
            return x-1;
        }
        else {
           return fibonacci(x-1) + fibonacci(x-2);
        }
    }

    private static int factorial(int x) {
        if (x == 1) {
            return x;
        }
        else {
            return x * factorial(x-1);
        }
    }
}
