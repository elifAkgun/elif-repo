package code.elif;

import code.elif.app.Shape;
import code.elif.app.ShapeService;

import java.util.*;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        ShapeService shapeService = new ShapeService();

        Comparator<Shape> comparator = (s1, s2) -> s1.getArea() > s2.getArea() ? -1
                : s1.getArea() > s2.getArea() ? 1 : 0;

        System.out.println("Shapes are adding into List....\n");
        List<Shape> shapes = (List) shapeService.getShapes(new ArrayList());
        drawAllShapes(shapes);

        System.out.println("\nShapes are sorting desc....\n");
        shapes.sort(comparator);
        drawAllShapes(shapes);

        System.out.println("\n*****************\nShapes are adding into TreeMap from List....\n");
        TreeMap<Integer, Shape> shapeTreeMap = new TreeMap<>();
        for (Shape s : shapes) {
            shapeTreeMap.put((int) s.getArea(), s);
        }
        for (Map.Entry<Integer, Shape> entry : shapeTreeMap.entrySet()) {
            entry.getValue().draw();
        }

        System.out.println("\n******************\nShapes are getting into TreeSet....");
        TreeSet<Shape> shapeTreeSet = (TreeSet<Shape>) shapeService.getShapes(new TreeSet<>(comparator));

        Predicate<Shape> greaterThanTen = s -> s.getArea() > 10;
        System.out.println("List if only area is greater than 10...");

        Predicate<Collection> isCollectionEmpty = c -> c.isEmpty();
        if (!isCollectionEmpty.test(shapeTreeSet)) {
            for (Shape s : shapeTreeSet) {
                if (greaterThanTen.test(s)) {
                    s.draw();
                }
            }
        }
    }

    private static void drawAllShapes(List<Shape> shapes) {
        for (Shape s : shapes) {
            s.draw();
        }
    }
}





