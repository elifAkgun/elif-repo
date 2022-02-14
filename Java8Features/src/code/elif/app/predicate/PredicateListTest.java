package code.elif.app.predicate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class PredicateListTest {

    public static void main(String[] args) {
        List<String> list = getList();

        Predicate<String> isElementEmptyOrNull = s -> s == null || s == "";

        Iterator<String> iterable = list.iterator();
        while (iterable.hasNext()){
            String s = iterable.next();
            if (isElementEmptyOrNull.test(s)) {
                iterable.remove();
            }
        }

        for (String s : list) {
            System.out.print(s + ", ");
        }
    }

    private static List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("");
        list.add(null);
        list.add("Apple");
        list.add("");
        list.add("Banana");
        return list;
    }
}
