package code.elif.app.features.java11;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class StringAPIExample {
    public static void main(String[] args) {
        linesMethodExample();
    }

    private static void linesMethodExample() {
        var multiLines = "\nI am so happy"
                + "\nto write code"
                + "\nwith \n\rJava!";

        String linesUsingSeparator[] = multiLines.split(System.lineSeparator());
        for (String line : linesUsingSeparator) {
            System.out.println(line);
        }

        multiLines.lines().forEach(System.out::println);
    }


    private static void stripVsTrim() {
        var text = "    hello   \u2001";
        System.out.println("text.trim():\t\t\t\t '" + text.trim() + "' text.trim().length(): " + text.trim().length());
        System.out.println("text.strip():\t\t\t\t '" + text.strip() + "' text.strip().length(): " + text.strip().length());
        System.out.println("text.stripLeading():\t\t '" + text.stripLeading() + "' text.stripLeading().length(): " + text.stripLeading().length());
        System.out.println("text.stripTrailing():\t\t '" + text.stripTrailing() + "' text.stripTrailing().length(): " + text.stripTrailing().length());

        System.out.println(Character.isWhitespace('\u2001'));
    }

    private static void isBlankVsIsEmpty() {
        String blank = " ";
        String empty = "";

        System.out.println("blank.isEmpty() " + blank.isEmpty());
        System.out.println("blank.isBlank() " + blank.isBlank());

        System.out.println("empty.isEmpty() " + empty.isEmpty());
        System.out.println("empty.isBlank() " + empty.isBlank());
    }

    private static void repeatExample() {
        String expensiveness = "₺";
        Map<String, Integer> restaurant = Map.of(
                "Joe's Place", 1,
                "Big Chefs", 7,
                "Kebab", 2,
                "Humus Cafe", 4);

        for (Map.Entry<String, Integer> e : restaurant.entrySet()) {
            System.out.println(e.getKey() + " - " + expensiveness.repeat(e.getValue()));
        }
    }
}
