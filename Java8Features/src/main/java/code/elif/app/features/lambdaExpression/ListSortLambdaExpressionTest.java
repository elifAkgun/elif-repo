package code.elif.app.features.lambdaExpression;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListSortLambdaExpressionTest {
    public static void main(String[] args) {
        Comparator<Integer> comparator2 = (x, y) -> x > y ? -1 : x > y ? 1 : 0;
        List<Integer> list = Arrays.asList(1,4,43,95,2,33,27,8);
        list.sort(comparator2);
        System.out.println(list);
    }
}
