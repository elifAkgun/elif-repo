package code.elif.webfluxdemo.exception;

import java.math.BigDecimal;

public class InputValidationException extends RuntimeException {
    private final String message;
    private static final Integer code= 100;
    private final Object input;

    public InputValidationException(BigDecimal input, String message) {
        super(message);
        this.input = input;
        this.message = message;
    }

    public InputValidationException(Integer input, String message) {
        super(message);
        this.input = input;
        this.message = message;
    }

    public Object getInput() {
        return input;
    }

    public Integer getCode() {
        return code;
    }
}
