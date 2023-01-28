package code.elif.app.features.java10.stream.ofNullable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Shows ofNullable introduced in Stream interface.
public class StreamOfNullable {
    static List<String> fruits = List.of("Banana", "Apple", "Strawberry",
            "Pineapple", "Orange");

    public static void main(String[] args) {
      //  nullInStream();
        //    filter();
        // flatMap();
       flatMapOfNullable();
    }

    public static void nullInStream() {
        Map<String, Integer> fruitsStock = getFruitsStock();
        List<Integer> allStock =
                fruits.stream()
                        .map(fruit -> fruitsStock.get(fruit))
                        .collect(Collectors.toList());
        System.out.println("Total Stock:" + allStock);

        Optional<Integer> totalStock =
                allStock.stream()
                        .reduce(Integer::sum);
    }

    public static void filter() {
        Map<String, Integer> fruitsStock = getFruitsStock();
        List<Integer> allStock =
                fruits.stream()
                        .map(fruitsStock::get)
                        .peek(System.out::println)
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList());
        System.out.println("Total Stock:" + allStock);
    }

    public static void flatMap() {
        Map<String, Integer> fruitsStock = getFruitsStock();

        List<Integer> allStock =
                fruits.stream()
                        .flatMap(fruit -> {
                            Integer stock = fruitsStock.get(fruit);
                            return stock != null ? Stream.of(stock) : Stream.empty();
                        })
                        .peek(System.out::println)
                        .collect(Collectors.toList());
        System.out.println("Total Stock flatMap:" + allStock);
    }

    public static void flatMapOfNullable() {
        Map<String, Integer> stockMap = getFruitsStock();

        List<Integer> allStock =
                fruits.stream()
                        .flatMap(fruit -> Stream.ofNullable(stockMap.get(fruit)))
                        .peek(System.out::println)
                        .collect(Collectors.toList());
        System.out.println("Total Stock flatMap + ofNullable:" + allStock);
    }

    private static Map<String, Integer> getFruitsStock() {
        final Map<String, Integer> stocks = new HashMap<>();
        stocks.put("Banana", 10);
        stocks.put("Apple", 20);
        stocks.put("Pineapple", 19);
        stocks.put("Blueberry", 15);
        stocks.put("Orange", 13);
        return stocks;
    }
}
