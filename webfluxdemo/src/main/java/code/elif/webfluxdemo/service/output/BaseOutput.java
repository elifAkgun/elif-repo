package code.elif.webfluxdemo.service.output;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class BaseOutput implements Serializable {

    private LocalDateTime responseTime = LocalDateTime.now();

}
