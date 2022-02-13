package code.elif;

import code.elif.app.Shape;
import code.elif.app.ShapeService;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Predicate;

public class Main {


    public static void main(String[] args) {

        ShapeService shapeService = new ShapeService();


        List<Shape> shapes = shapeService.getShapes();


        for (Shape s : shapes) {
            s.draw(s.getEdges());
            System.out.println(s.getArea());
        }
 /*
        Comparator<Shape> comparator = Comparator.comparingDouble(AreaCalculator::getArea);
        Comparator<Shape> comparator2 = (s1, s2) -> s1.getArea() > s2.getArea() ? -1
                : s1.getArea() > s2.getArea() ? 1 : 0;

        shapes.sort(comparator);

        System.out.println("Shapes are sorting asc....");
        for (Shape s : shapes) {
            s.draw();
        }

        shapes.sort(comparator2);

        System.out.println("\nShapes are sorting desc....");
        for (Shape s : shapes) {
            s.draw();
        }

        TreeMap<Integer, Shape> shapeTree = new TreeMap<>();

        for (Shape s : shapes) {
            shapeTree.put((int) s.getArea(), s);
        }

        for (Map.Entry<Integer, Shape> entry : shapeTree.entrySet()) {
            System.out.println(entry.getKey());
        }

        */
        System.out.println();
        System.out.println("******************\n");

        Comparator<Shape> comparator = (s1, s2) -> s1.getArea() > s2.getArea() ? -1
                : s2.getArea() > s1.getArea() ? 1 : 0;

        TreeSet<Shape> shapeTree = new TreeSet<>(comparator);

        for (Shape s : shapes) {
            shapeTree.add(s);
        }

        Predicate<Shape> p = s -> s.getArea() > 10;
        System.out.println("List only if area greater than 10...");

        Predicate<Collection> p2 = c -> c.isEmpty();
        if (!p2.test(shapeTree)) {
            System.out.println("ShapesTree are not empty...");
            for (Shape s : shapeTree) {
                if (p.test(s)) {
                    s.draw(s.getEdges());
                    System.out.println("Area : " + s.getArea() + "\n");
                }
            }
        }

    }
}
