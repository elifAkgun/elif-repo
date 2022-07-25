package code.elif;

import java.util.LinkedList;
import java.util.List;


//A concrete subject 
public class Order {

    private String id;

    private double shippingCost;
    //cost of items
    private double itemCost;

    private double discount;
    //no of items
    private int count;

    private List<OrderObserver> orderObserverList;

    public Order(String id) {
        this.id = id;
        this.orderObserverList = new LinkedList<OrderObserver>();
    }

    public void attach(OrderObserver orderObserver){
        orderObserverList.add(orderObserver);
    }

    public void detach(OrderObserver orderObserver){
        if(orderObserverList.contains(orderObserver))
            orderObserverList.remove(orderObserver);
    }

    public double getTotal() {
        return itemCost - discount + shippingCost;
    }

    public void addItem(double price) {
        itemCost += price;
        count ++;
        orderObserverList.forEach(o -> o.updated(this));
    }

    public int getCount() {
        return count;
    }

    public void setShippingCost(double cost) {
        this.shippingCost = cost;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getItemCost() {
        return itemCost;
    }

    @Override
    public String toString() {

        return "Order#"+id+"\nItem cost:"+itemCost+"\nNo. of items:"+count
                +"\nShipping cost:"+shippingCost+"\nDiscount:"+discount
                +"\nTotal:"+getTotal();
    }
}
