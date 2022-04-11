package code.elif.app.features.stream;

import code.elif.app.model.Shape;
import code.elif.app.service.ShapeService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    static ShapeService shapeService;
    static List<Shape> shapeList;
    static List<Integer> list = Arrays.asList(10, 15, 25, 20, 5, 0);

    public static void main(String[] args) {
        //filterExample();
        // filterShapeExample();
        // mapExample();
        // processByCount();
        // processBySorted();
        // processByMaxAndMin();
        // processByForeach();
        streamCountExample();
    }

private static void filterExample() {
    List<Integer> list = Arrays.asList(10, 15, 25, 20, 5, 0);
    List<Integer> collectedList = list.stream().filter(i -> i % 2 == 0)
            .collect(Collectors.toList());
    System.out.println(collectedList);
}

    private static void processByForeach() {
        list.stream().forEach(s -> System.out.println(+s));
    }

    private static void processByMaxAndMin() {
        Integer min = list.stream().min((a, b) -> a > b ? 1 : -1).get();
        Integer max = list.stream().max((a, b) -> a > b ? 1 : -1).get();

        System.out.println("Min value for list : " + min);
        System.out.println("Max value for list : " + max);

    }

    private static void processBySorted() {
        List<Integer> list1 = list.stream().map(l -> l * 2).sorted().collect(Collectors.toList());
        System.out.println("ascending order" + list1);

        List<Integer> list2 = list.stream()
                .map(l -> l * 2).sorted((a, b) -> a > b ? -1 : 1)
                .collect(Collectors.toList());
        System.out.println("descending order" + list2);
    }

    private static void processByCount() {
        shapeService = new ShapeService();
        long count = shapeList.stream()
                .filter(s -> s.getArea() > 50)
                .count();
        System.out.println("Only " + count + " shape(s) founded in the list.");
    }

    private static void streamCountExample() {
        List<Integer> list = Arrays.asList(10, 15, 25, 20, 5, 0);
        long count = list.stream()
                .filter(s -> s > 15)
                .count();
        System.out.println("Only " + count + " item(s) founded in the list.");
    }

    private static void runMapExample() {
        shapeService = new ShapeService();
        shapeList = (List<Shape>) shapeService.getShapes(new ArrayList());
        List<Integer> doubledList = list.stream().map(l -> l * 2).collect(Collectors.toList());
        for (int l : doubledList) {
            System.out.println(l);
        }
    }

    private static void filterShapeExample() {
        shapeList = (List<Shape>) shapeService.getShapes(new ArrayList());

        List<Shape> shapeList = (List<Shape>) shapeService.getShapes(new ArrayList());

        List<Shape> collectedList = shapeList.stream()
                .filter(s -> s.getArea() > 50)
                .collect(Collectors.toList());
        for (Shape s : collectedList) {
            s.draw();
        }
    }
}