package code.elif.app;

import java.util.List;

public interface Shape2 {

    default void draw(List<Double> edges) {
      System.out.println("draw is calling...");
    }
}
