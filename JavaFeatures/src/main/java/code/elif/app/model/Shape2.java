package code.elif.app.model;

public interface Shape2 {

    default void draw() {
        System.out.println("draw is calling...");
    }
}
