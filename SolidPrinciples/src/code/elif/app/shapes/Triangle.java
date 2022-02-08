package code.elif.app.shapes;

import code.elif.app.Shape;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Triangle implements Shape {

    private double x;
    private double y;
    private double z;

    public Triangle(double edge1, double edge2, double edge3){
        this.x =edge1;
        this.y =edge2;
        this.z =edge3;
    }

    @Override
    public void draw() {
        System.out.println("Triangle is drawing... " +
                " edge1 : " + this.x +
                " edge2 : " + this.y +
                " edge3 : " + this.z);
    }

    @Override
    public double getArea() {
        double area = (z * sqrt(y * y - pow(((x * x - y * y - z * z) / (2 * z)), 2))) / 2;
        return Math.round(area);
    }
}
