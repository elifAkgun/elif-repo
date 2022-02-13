package code.elif.app;


import code.elif.app.shapes.Circle;
import code.elif.app.shapes.Rectangle;
import code.elif.app.shapes.Square;
import code.elif.app.shapes.Triangle;

import java.util.ArrayList;
import java.util.List;

public class ShapeService {

    public List<Shape> getShapes() {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(3));
        shapes.add(new Square(4));
        shapes.add(new Triangle(8, 15, 17));
        shapes.add(new Rectangle(2,4));
        return shapes;
    }
}
