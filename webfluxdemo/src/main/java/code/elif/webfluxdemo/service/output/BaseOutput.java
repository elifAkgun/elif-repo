package code.elif.webfluxdemo.service.output;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
public class BaseOutput implements Serializable {

    private LocalDateTime responseTime = LocalDateTime.now();

}
