package code.elif;

public class ShapeFactory {

    enum ShapeType {
        CIRCLE,
        TRIANGLE
    }

    public static Shape getShape(ShapeType shapeType) {
        switch (shapeType) {
            case CIRCLE:
                return new Circle();
            case TRIANGLE:
                return new Triangle();
        }
       throw new IllegalArgumentException("Incompatible enum type...");
    }
}
