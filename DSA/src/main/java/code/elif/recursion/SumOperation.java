package code.elif.recursion;

public class SumOperation {

    public static void main(String[] args) {
        int totalSum = totalSum(5);

        System.out.println(totalSum);
    }

    private static int totalSum(int i) {
        if (i == 1) {
            return 1; // base condition
        }
        return i + totalSum(i - 1);
    }
}
