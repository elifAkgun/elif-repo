package code.elif;

import java.util.LinkedList;

public class Client {

	public static void main(String[] args) {

		Order o = new Order("100");
		o.addItem("Soda", 2);
		o.addItem("Chips", 10);
		o.addItem("Cake", 20);

		OrderPrinter orderPrinter = new HtmlPrinter();

		orderPrinter.printOrder(o);
	}

}
