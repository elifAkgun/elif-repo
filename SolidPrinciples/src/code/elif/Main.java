package code.elif;

import code.elif.app.AreaCalculator;
import code.elif.app.Shape;
import code.elif.app.ShapeService;

import java.util.Comparator;
import java.util.List;

public class Main {



    public static void main(String[] args) {

        ShapeService shapeService = new ShapeService();
        List<Shape> shapes = shapeService.getShapes();

        for (Shape s : shapes) {
            s.draw();
            System.out.println(s.getArea());
        }

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

    }
}
