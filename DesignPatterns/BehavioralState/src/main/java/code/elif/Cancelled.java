package code.elif;

public class Cancelled implements OrderState {

    @Override
    public double handleCancellation() {
        throw new IllegalStateException("Cancel order cannot cancel again!");
    }
}
