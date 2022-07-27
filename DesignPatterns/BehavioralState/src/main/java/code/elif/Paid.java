package code.elif;

public class Paid implements OrderState {

    @Override
    public double handleCancellation() {
        System.out.println("This is a paid order. Rollback order's transaction was completed. ");
        return 10;
    }
}
