package code.elif.domain.service.data;

import code.elif.domain.model.Order;
import code.elif.domain.model.User;
import com.github.javafaker.Faker;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Data
public class DataProvider {
   private final Map<String, List<Order>> orderMap = new HashMap<>();
   private final List<User> userList = new ArrayList<>();


   public DataProvider(){
       generateData();
   }


    private void generateData() {
        for (int i = 0; i < 10; i++) {
            String id = Faker.instance().idNumber().valid();
            userList.add(User.builder()
                            .age(Faker.instance().random().nextInt(18,45))
                            .name(Faker.instance().name().name())
                            .id(id)
                    .build());
            List<Order> orders = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                orders.add(Order.builder()
                        .createDate(Faker.instance().date().past(10, TimeUnit.DAYS).toString())
                        .itemName(Faker.instance().commerce().productName())
                        .userId(id)
                        .build());
            }
            orderMap.put(id, orders);
        }
    }
}
