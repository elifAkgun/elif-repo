package code.elif.recursionType;

public class RecursionType {

    public static void main(String[] args) {

        Thread headRecursion = new Thread(() -> {
            headRecursion(5);
        });

        Thread tailRecursion = new Thread(() -> {
            tailRecursion(5);
        });

        tailRecursion.start();
        headRecursion.start();
    }

    private static void tailRecursion(int i) {
        if (i == 0)
            return;
        System.out.println(i);
        tailRecursion(i - 1);
    }

    private static void headRecursion(int i) {
        if (i == 0)
            return;
        headRecursion(i - 1);
        System.out.println(i);
    }
}
