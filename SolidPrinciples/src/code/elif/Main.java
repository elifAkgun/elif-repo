package code.elif;

import code.elif.liskov.Circle;
import code.elif.liskov.Shape;
import code.elif.liskov.Square;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();

        shapes.add(new Circle(3));
        shapes.add(new Square(4));

        for (Shape s : shapes){
            s.draw();
        }
    }
}
