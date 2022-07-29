package code.elif;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Order {

    @NonNull
    private String id;

    private LocalDate date;

    private Map<String, Double> items = new HashMap<>();

    private double total;

    public Order(String id) {
        this.id = id;
        date = LocalDate.now();
    }

    public void addItem(String name, double price) {
        items.put(name, price);
        total += price;
    }

}
