package code.elif.array;

import java.util.Arrays;

public class DuplicateExample {

    public static void main(String[] args) {

        int array[] = {0, 10, 20, 30, 40, 20, 60, 70, 30};

        Arrays.sort(array);

        for (int i = 1; i < array.length; i++) {
            if (array[i-1] == array[i] ) {
                System.out.println(array[i]);
            }
        }
    }
}
