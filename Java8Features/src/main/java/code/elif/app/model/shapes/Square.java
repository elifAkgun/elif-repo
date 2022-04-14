package code.elif.app.model.shapes;

import code.elif.app.model.Shape;

import java.util.Arrays;
import java.util.List;

import static java.lang.Double.compare;

public class Square implements Shape {

    private double edge;

    public Square(double edge) {
        this.edge = edge;
    }

    @Override
    public List<Double> getEdges() {
        return Arrays.asList(edge);
    }

    @Override
    public double getArea() {
        return Math.round(edge * edge);
    }

    @Override
    public int compareTo(Shape t) {
        return compare(this.getArea(), t.getArea());
    }
}
