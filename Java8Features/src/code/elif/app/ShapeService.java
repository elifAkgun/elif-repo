package code.elif.app;


import code.elif.app.shapes.Circle;
import code.elif.app.shapes.Rectangle;
import code.elif.app.shapes.Square;
import code.elif.app.shapes.Triangle;

import java.util.ArrayList;
import java.util.Collection;

public class ShapeService {

    public Collection<Shape> getShapes(Collection collection) {
        Collection<Shape> shapes = collection;
        shapes.add(new Circle(3));
        shapes.add(new Square(4));
        shapes.add(new Triangle(8, 15, 17));
        shapes.add(new Rectangle(23, 4));
        shapes.add(new Circle(2));
        shapes.add(new Rectangle(2, 4));
        return shapes;
    }
}
