package code.elif.liskov;

public class Square implements Shape {

    private int edge;

    public Square(int edge){
        this.edge = edge;
    }

    @Override
    public void draw() {
        System.out.println("Square is drawing... Edge: " + this.edge);
    }
}
