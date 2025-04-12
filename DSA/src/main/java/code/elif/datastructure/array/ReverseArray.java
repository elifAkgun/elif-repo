package code.elif.datastructure.array;

public class ReverseArray {

    public static void main(String[] args) {
        int[] array = {0, 10, 20, 30, 40, 50, 60, 70, 80};

        reverse(array, array.length);

        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
    }

    private static void reverse(int[] a, int length) {
        for (int i = 0; i < length / 2; i++) {
            int temp = a[i];
            a[i] = a[length - 1 - i];
            a[length - 1 - i] = temp;
        }
    }
}
