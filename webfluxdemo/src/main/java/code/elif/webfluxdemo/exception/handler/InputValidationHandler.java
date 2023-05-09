package code.elif.webfluxdemo.exception.handler;

import code.elif.webfluxdemo.controller.response.FailedResponse;
import code.elif.webfluxdemo.exception.InputValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InputValidationHandler {

    @ExceptionHandler(InputValidationException.class)
    public ResponseEntity<FailedResponse> handle(InputValidationException ex){
        FailedResponse failedResponse = new FailedResponse();
        failedResponse.setErrorCode(ex.getCode());
        failedResponse.setInput(ex.getInput());
        failedResponse.setMessage(ex.getMessage());
        return ResponseEntity.badRequest().body(failedResponse);
    }
}
