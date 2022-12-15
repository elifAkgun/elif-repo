package code.elif.app.features.stream.maxAndMin;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamMaxMinExample {

    public static void main(String[] args) {
        processByMaxAndMin();
    }

    private static void processByMaxAndMin() {
        List<Integer> list = Arrays.asList(10, 15, 25, 20, 5, 0);

        Integer min = list.stream().min((a, b) -> a > b ? 1 : -1).get();
        Integer min2 = list.stream().min(Integer::compareTo).get();

        Integer max = list.stream().max((a, b) -> a > b ? 1 : -1).get();
        Integer max2 = list.stream().max(Integer::compareTo).get();

        System.out.println("Min value for list : " + min);
        System.out.println("Min value for list : " + min2);
        System.out.println("Max value for list : " + max);
        System.out.println("Max value for list : " + max2);

    }
}
