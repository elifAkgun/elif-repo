package code.elif.app;

import java.util.List;

public interface Shape extends Comparable<Shape> {

    double getArea();

    List<Double> getEdges();

    default void draw() {
        System.out.println(this.getClass().getSimpleName() + " is drawing...  Area:" + getArea());
        for (int i = 0; i <  getEdges().size(); i++) {
            System.out.print(" Edge" + (i+1) + " : " +  getEdges().get(i));
        }

        System.out.println();
    }
}