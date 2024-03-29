package code.elif.app.model.shapes;

import code.elif.app.model.Shape;
import code.elif.app.model.Shape2;

import java.util.Arrays;
import java.util.List;

import static java.lang.Double.compare;
import static java.lang.Math.PI;

public class Circle implements Shape, Shape2 {


    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public List<Double> getEdges() {
        return Arrays.asList(radius);
    }

    @Override
    public void draw() {
        Shape2.super.draw();
    }


    @Override
    public double getArea() {
        return Math.round(PI * radius * radius);
    }

    @Override
    public Circle clone() {
        return this;
    }

    @Override
    public int compareTo(Shape c) {
        return compare(this.getArea(), c.getArea());
    }

}
