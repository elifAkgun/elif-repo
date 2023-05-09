package code.elif.webfluxdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseResponse<T> {

    private LocalDateTime responseTime;

    private T data;

    private String error;

}
