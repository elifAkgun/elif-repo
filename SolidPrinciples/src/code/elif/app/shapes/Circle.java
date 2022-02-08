package code.elif.app.shapes;

import code.elif.app.Shape;

import static java.lang.Math.PI;

public class Circle implements Shape {


    private double radius;

    public Circle(double radius){
        this.radius =radius;
    }


    @Override
    public void draw() {
        System.out.println("Circle is drawing... Radius : " + this.radius);
    }

    @Override
    public double getArea() {
        return Math.round(PI * radius * radius);
    }
}
