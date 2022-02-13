package code.elif.app.shapes;

import code.elif.app.Shape;
import code.elif.app.Shape2;

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
    public void draw(List<Double> edges) {
        Shape2.super.draw(edges);
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
