package code.elif.app.model.shapes;

import code.elif.app.model.Shape;

import java.util.Arrays;
import java.util.List;

import static java.lang.Double.compare;

public class Rectangle implements Shape, Comparable<Shape> {
    private double edge1;
    private double edge2;

    public Rectangle(double edge1, double edge2) {
        this.edge1 = edge1;
        this.edge2 = edge2;
    }

    @Override
    public double getArea() {
        return Math.round(edge1 * edge2);
    }

    @Override
    public List<Double> getEdges() {
        return Arrays.asList(edge1, edge2);
    }

    @Override
    public int compareTo(Shape r) {
        return compare(this.getArea(), r.getArea());
    }
}
