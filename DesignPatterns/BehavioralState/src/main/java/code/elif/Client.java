package code.elif;

public class Client {

    public static void main(String[] args) {
        Order order = new Order();
        order.cancel();
        System.out.println("----\n");

        Order order2 = new Order();
        order2.paymentSuccessful();
        order2.cancel();
        System.out.println("----\n");

        Order order3 = new Order();
        order3.dispatched();
        order3.cancel();
        System.out.println("----\n");

        Order order4 = new Order();
        order4.delivered();
        order4.cancel();
    }
}
