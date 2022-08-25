package code.elif;

import javafx.geometry.Point2D;
import lombok.Getter;
import lombok.Setter;

//concrete reusable

public class Bitmap implements Image {

    @Getter
    @Setter
    private Point2D location;

    private String name;

    public Bitmap(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println("Drawing "+name+" @ "+location);
    }

    @Override
    public void reset() {
        location = null;
        System.out.println("Object is reset");

    }
}
