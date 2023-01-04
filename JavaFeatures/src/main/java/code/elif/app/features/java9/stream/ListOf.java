package code.elif.app.features.java9.stream;

import code.elif.app.model.Employee;
import code.elif.app.model.Stock;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

import static java.util.Map.entry;

public class ListOf {

    public static void main(String[] args) {
        noNull();
    }

    public static void noNull() {
        System.out.println("Adding null in a call to List.of");
        List<String> fruits = List.of("Apple", "Orange", "Banana", null);
        System.out.println(fruits);
    }

    public static void ofVsUnmodifiableWithObject() {

        Stock apple = new Stock("Apple", new BigDecimal(1));
        Stock orange = new Stock("Orange", new BigDecimal(2));
        Stock banana = new Stock("Banana", new BigDecimal(2));

        List<Stock> stocksUsingOf = List.of(apple, orange, banana);

        // banana.setName("Pineapple"); --final field cannot change
        System.out.println("Using List.of :" + stocksUsingOf);
    }

    public static void ofVsUnmodifiable() {

        List<String> list = Arrays.asList("Apple", "Orange", "Banana");
        List<String> fruits = Collections.unmodifiableList(list);
        list.set(2, "Pineapple");

        System.out.println("Using Collections.unmodifiable : " + fruits);

        List<String> fruitsUsingOf = List.of("Apple", "Orange", "Banana");
        System.out.println("Using List.of : " + fruitsUsingOf);
    }

    public static void unmodifiableMapWithTenElements() {
        //If more than 10 entries...
        Map<String, Integer> fruitRanking =
                Map.ofEntries(
                        entry("Apple", 200),
                        entry("Orange", 210),
                        entry("Banana", 190),
                        entry("Strawberry", 250)
                );
        System.out.println(fruitRanking);
    }

    public static void unmodifiableMapUsingOf() {
        Map<String, Integer> fruitRanking =
                Map.of("Apple", 200, "Orange", 210, "Banana", 190);
        System.out.println(fruitRanking);
    }

    public static void unmodifiableSetOf() {
        Set<String> fruits = Set.of("Orange", "Apple", "Banana");
        System.out.println(fruits);
    }

    public static void unmodifiableListOf() {
        List<String> fruits = List.of("Apple", "Banana", "Orange");
        System.out.println(fruits);
    }

    public static void unmodifiableListArraysAsList() {
        List<String> fruits = Collections.unmodifiableList(
                Arrays.asList("Apple", "Banana", "Orange"));
        System.out.println(fruits);
    }

    public static void unModifiableListWithAdd() {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        List<String> fruits = Collections.unmodifiableList(list);
        System.out.println(fruits);
    }
}
