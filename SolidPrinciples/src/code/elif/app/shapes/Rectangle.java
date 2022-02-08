package code.elif.app.shapes;

import code.elif.app.Shape;

public class Rectangle implements Shape {
    private int edge1;
    private int edge2;

    public Rectangle(int edge1, int edge2) {
        this.edge1 = edge1;
        this.edge2 = edge2;
    }

    @Override
    public void draw() {
        System.out.println("Rectangle is drawing... edge1 : " + this.edge1 + " edge2 : " + this.edge2 );
    }

    @Override
    public double getArea() {
        return Math.round(edge1*edge2);
    }
}
