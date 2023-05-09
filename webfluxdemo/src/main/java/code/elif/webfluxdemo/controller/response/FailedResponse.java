package code.elif.webfluxdemo.controller.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FailedResponse {
    private Integer errorCode;
    private Object input;
    private String message;
}
