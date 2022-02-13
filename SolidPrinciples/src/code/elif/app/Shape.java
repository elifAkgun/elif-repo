package code.elif.app;

import java.util.List;

public interface Shape extends Comparable<Shape> {


    double getArea();

    List<Double> getEdges();

    default void draw(List<Double> edges) {
        System.out.print(this.getClass().getSimpleName() + " is drawing...");
        for (int i = 0; i < edges.size(); i++) {
            System.out.print(" edge" + i + ":" + edges.get(i));
        }
        System.out.println();
    }
}