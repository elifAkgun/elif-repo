package code.elif.app.shapes;

import code.elif.app.Shape;
import sun.security.provider.SHA;

import java.util.Arrays;
import java.util.List;

import static java.lang.Double.compare;

public class Square implements Shape, Comparable<Shape> {

    private double edge;

    public Square(double edge){
        this.edge = edge;
    }

    @Override
    public List<Double> getEdges() {
        return Arrays.asList(edge);
    }

    @Override
    public double getArea() {
        return Math.round(edge*edge);
    }

    @Override
    public int compareTo(Shape t) {
        return compare(this.getArea(), t.getArea());
    }
}
