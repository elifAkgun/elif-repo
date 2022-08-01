package code.elif;

public class Client {

    public static void main(String[] args) {
        Order o = getOrder();
        OrderPrinter orderPrinter = new HtmlPrinter();
        orderPrinter.printOrder(o);
    }

    private static Order getOrder() {
        Order o = new Order("100");
        o.addItem("Soda", 2);
        o.addItem("Chips", 10);
        o.addItem("Cake", 20);
        return o;
    }
}
