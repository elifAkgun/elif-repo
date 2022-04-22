package code.elif.iteration;

public class Recursion {

    public static void main(String[] args) {
        System.out.println(sumIntegers(3));
    }

    private static int sumIntegers(int num) {
        if (num == 1) {
            return 1;
        }
        return num + sumIntegers(--num);
    }
}
