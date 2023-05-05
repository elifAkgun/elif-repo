package code.elif.domain.service.data;

import code.elif.domain.model.Order;
import code.elif.domain.model.User;
import com.github.javafaker.Commerce;
import com.github.javafaker.Faker;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class DataProvider {
    private final Map<String, List<Order>> orderMap = new HashMap<>();
    private final List<User> userList = new ArrayList<>();


    public DataProvider() {
        generateData();
    }


    private void generateData() {
        for (int i = 0; i < 10; i++) {
            String id = Faker.instance().idNumber().valid();
            userList.add(User.builder()
                    .age(Faker.instance().random().nextInt(18, 45))
                    .name(Faker.instance().name().name())
                    .id(id)
                    .build());
            List<Order> orders = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                Commerce commerce = Faker.instance().commerce();
                orders.add(Order.builder()
                        .itemName(commerce.productName())
                        .price(new BigDecimal(Faker.instance().number().numberBetween(1, 10)))
                        .category(commerce.department())
                        .build());
            }
            orderMap.put(id, orders);
        }
    }
}
