package code.elif;

//Concrete implementation.
public class TextPrinter extends OrderPrinter {

    @Override
    protected String start() {
        return "-------Print Orders-------";
    }

    @Override
    protected String formatOrderNumber(Order order) {
        return "#" + order.getId();
    }

    @Override
    protected String formatItems(Order order) {
        StringBuilder formattedItems = new StringBuilder();
        order.getItems().entrySet().forEach((entry) ->
                formattedItems.append("Item name\t" + entry.getKey()
                        + "\tPrice\t" + entry.getValue() + "\n"));

        return formattedItems.toString();
    }

    @Override
    protected String formatTotal(Order order) {
        return "Total : " + order.getTotal();
    }

    @Override
    protected String end() {
        return "-------End-------";
    }
}
