package code.elif;

//Context class
public class Order {

    OrderState orderState;

    public Order() {
        this.orderState = new New();
    }


    public double cancel() {
        double charges = orderState.handleCancellation();
        orderState = new Cancelled();
        return charges;
    }

    public void paymentSuccessful() {
        orderState = new Paid();
    }

    public void dispatched() {
        orderState = new InTransit();
    }

    public void delivered() {
        orderState = new Delivered();
    }
}
