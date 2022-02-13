package code.elif.app.shapes;

import code.elif.app.Shape;

import java.util.Arrays;
import java.util.List;

import static java.lang.Double.compare;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Triangle implements Shape, Comparable<Shape> {

    private double x;
    private double y;
    private double z;

    public Triangle(double edge1, double edge2, double edge3) {
        this.x = edge1;
        this.y = edge2;
        this.z = edge3;
    }

    @Override
    public List<Double> getEdges() {
        return Arrays.asList(x, y, z);
    }

    @Override
    public double getArea() {
        double area = (z * sqrt(y * y - pow(((x * x - y * y - z * z) / (2 * z)), 2))) / 2;
        return Math.round(area);
    }

    @Override
    public int compareTo(Shape t) {
        return compare(this.getArea(), t.getArea());
    }
}
