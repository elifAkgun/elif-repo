package code.elif.app.features.java16.record;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer{

    private String name;
    private int age;
}