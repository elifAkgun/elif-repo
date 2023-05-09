package code.elif.webfluxdemo.exception;

public class InputValidationException extends RuntimeException {
    private static final String message= "Number should be between 1-20";
    private static final Integer code= 100;
    private final Integer input;

    public InputValidationException(Integer input) {
        super(message);
        this.input = input;
    }

    public Integer getInput() {
        return input;
    }

    public Integer getCode() {
        return code;
    }
}
