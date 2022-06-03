package code.elif;


//This is our client which also works as "director"
public class Client {

    public static void main(String[] args) {
        Shape shape = ShapeFactory.getShape(ShapeFactory.ShapeType.CIRCLE);
        System.out.println("This is a " + shape.getName());
    }

}
