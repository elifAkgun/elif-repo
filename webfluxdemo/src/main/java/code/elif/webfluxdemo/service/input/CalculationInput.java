package code.elif.webfluxdemo.service.input;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CalculationInput {

    private BigDecimal number1;
    private BigDecimal number2;
}
