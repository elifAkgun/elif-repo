package code.elif.recursion;

public class BinarySearch {

    public static void main(String[] args) {
        int [] a = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110};
        System.out.println(findIndex(120, a, 0, a.length));
    }

    private static int findIndex(int number, int[] a, int left, int right) {
        if (left >= right) {
            return -1;
        }

        int middle = (left + right) / 2;
        if (a[middle] == number) {
            return middle;
        } else {
            if (number > a[middle]) {
                left = middle + 1;
            } else {
                right = middle;
            }
            return findIndex(number, a, left, right);
        }
    }
}
