package code.elif;

import code.elif.app.*;
import code.elif.app.shapes.Circle;
import code.elif.app.shapes.Rectangle;
import code.elif.app.shapes.Square;
import code.elif.app.shapes.Triangle;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();

        shapes.add(new Circle(3));
        shapes.add(new Square(4));
        shapes.add(new Triangle(8, 15, 17));
        shapes.add(new Rectangle(4,4));

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
