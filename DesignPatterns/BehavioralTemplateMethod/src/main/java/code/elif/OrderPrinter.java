package code.elif;

import com.sun.tools.corba.se.idl.constExpr.Or;

//Abstract base class defines the template method
public abstract class OrderPrinter {

    public void printOrder(Order order) {
        System.out.println(start());
         System.out.println(formatOrderNumber(order));
         System.out.println(formatItems(order));
         System.out.println(formatTotal(order));
         System.out.println(end());
    }

    protected abstract String start();

    protected abstract String formatOrderNumber(Order order);

    protected abstract String formatItems(Order order);

    protected abstract String formatTotal(Order order);

    protected abstract String end();
}
