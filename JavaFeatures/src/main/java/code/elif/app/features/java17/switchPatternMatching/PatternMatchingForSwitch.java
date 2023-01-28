package code.elif.app.features.java17.switchPatternMatching;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class PatternMatchingForSwitch {

    public static void main(String[] args) {
        var result = getResult(List.of("Apple", "Orange"));
        System.out.println(result);
    }

    public static String getResult(Object value) {
        return switch (value) {
            case String s -> "A string of length : " + s.length();
            case List list && list.size() > 10000 -> "List is too large";
            case List list -> "List of size : " + list.size();
            case Map map -> "Map of entry size : " + map.size();
            case Set set -> "Set of element size : " + set.size();
            default -> throw new IllegalStateException("Unexpected value: " + value);
        };
    }
}
