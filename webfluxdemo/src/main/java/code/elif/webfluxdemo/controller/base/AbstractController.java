package code.elif.webfluxdemo.controller.base;

import code.elif.webfluxdemo.BaseResponse;

import java.time.LocalDateTime;

public class AbstractController<T> {
    protected BaseResponse getSuccessBaseResponse(T data) {
        return new BaseResponse(LocalDateTime.now(), data, null);
    }
}
