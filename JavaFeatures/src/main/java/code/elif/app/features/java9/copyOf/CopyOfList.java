package code.elif.app.features.java9.copyOf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Example shows how to use copyOf method in a List.
public class CopyOfList {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Pineapple");
        fruits.add("Orange");

        usingCopyOf(fruits);
        usingUnmodifiableView(fruits);
    }

    public static void usingUnmodifiableView(List<String> fruits) {
        List<String> fruitCopy = Collections.unmodifiableList(fruits);
        // fruitCopy.add("Blueberry"); //throws UnsupportedOperationException
        fruits.add("Strawberry");
        System.out.println("Original - " + fruits);
        System.out.println("UnmodifiableList - " + fruitCopy);
    }

    public static void usingCopyOf(List<String> fruits) {

        List<String> fruitCopy = List.copyOf(fruits);
        // fruitCopy.add("Blueberry"); //throws UnsupportedOperationException
        fruits.add("CherryBerry");
        System.out.println("Original - " + fruits);
        System.out.println("CopyOf - " + fruitCopy);
    }
}

