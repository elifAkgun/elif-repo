package code.elif.app.features.java16.record;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CustomerLocationTest {

    public static void main(String[] args) {

        //Compound key.
        Map<CustomerLocation, LocalDate> customerLocations = getCustomerLocation();
        var turkey = new Location("Turkey", "Istanbul");
        var ahmet = new Customer("Ahmet", 35);

        LocalDate lastSpotted = customerLocations.get(new CustomerLocation(ahmet, turkey));

        System.out.println("Last Spotted on : " + lastSpotted);
    }


    private static Map<CustomerLocation, LocalDate> getCustomerLocation() {
        var customerLocationVisited = new HashMap<CustomerLocation, LocalDate>();

        //Ben
        var uk = new Location("UK", "London");
        var ben = new CustomerLocation(new Customer("Ben", 30), uk);

        customerLocationVisited.put(ben, LocalDate.now());

        //Emily
        var emily = new CustomerLocation(new Customer("Emily", 30), uk);
        customerLocationVisited.put(emily, LocalDate.of(2022, 1, 1));

        //Ahmet
        var turkey = new Location("Turkey", "Istanbul");
        var ahmet = new CustomerLocation(new Customer("Ahmet", 35), turkey);
        customerLocationVisited.put(ahmet, LocalDate.of(2022, 1, 1));

        return customerLocationVisited;
    }
}
