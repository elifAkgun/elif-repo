package code.elif;

public class New implements OrderState {

    @Override
    public double handleCancellation() {
        System.out.println("It is a new order. The order was cancelled!");
        return 0;
    }
}
