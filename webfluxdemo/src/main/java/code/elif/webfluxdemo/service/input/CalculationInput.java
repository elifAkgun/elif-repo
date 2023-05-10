package code.elif.webfluxdemo.service.input;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CalculationInput {

    private Integer number1;
    private Integer number2;
}
