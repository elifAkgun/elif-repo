package code.elif;

public class Client {

    public static void main(String[] args) {

        Order order = new Order("1");
        PriceObserver priceObserver = new PriceObserver();
        order.attach(priceObserver);


        QuantityObserver quantityObserver = new QuantityObserver();
        order.attach(quantityObserver);

        order.addItem(100);
        order.addItem(500);

        System.out.println(order);
    }
}
