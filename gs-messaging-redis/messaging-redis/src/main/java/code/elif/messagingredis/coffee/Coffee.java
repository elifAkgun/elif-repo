package code.elif.messagingredis.coffee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {
    private String id;
    private String name;
}