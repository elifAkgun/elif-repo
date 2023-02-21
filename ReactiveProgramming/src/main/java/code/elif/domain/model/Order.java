package code.elif.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@ToString
@Data
public class Order {

    private String userId;
    private String createDate;
    private String itemName;
}
