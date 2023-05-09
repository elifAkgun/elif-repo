package code.elif.webfluxdemo.service.input;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MultiplicationInput {

    private Integer number1;
    private Integer number2;
}
