package code.elif.app.features.stream.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StreamMapExample {

    public static void main(String[] args) {
        runMapExample();
    }

    private static void runMapExample() {
        List<Integer> list = Arrays.asList(10, 15, 25, 20, 5, 0);
        List<Integer> doubledList = list.stream().map(l -> l * 2).collect(Collectors.toList());
        for (int l : doubledList) {
            System.out.println(l);
        }
    }

}
