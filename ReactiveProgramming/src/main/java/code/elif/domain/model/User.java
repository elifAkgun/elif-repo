package code.elif.domain.model;

import com.github.javafaker.Faker;
import lombok.*;

@Data
@ToString
@Builder
@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private Integer age;

    public User() {
        this.age = Faker.instance().random().nextInt(1, 40);
        this.name = Faker.instance().name().name();
        this.id = Faker.instance().idNumber().valid();
    }
}