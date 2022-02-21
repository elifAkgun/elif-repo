package code.elif.app;

import java.util.List;

public interface Shape extends Comparable<Shape> {

    double getArea();

    List<Double> getEdges();

    default void draw(List<Double> edges) {
        System.out.println(this.getClass().getSimpleName() + " is drawing...  Area:" + getArea());
        for (int i = 0; i < edges.size(); i++) {
            System.out.print(" Edge" + (i+1) + " : " + edges.get(i));
        }

        System.out.println();
    }
}