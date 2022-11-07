package code.elif.bootMySqlDocker.model;

import lombok.*;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cambly {

    @NonNull
    private String mistake;
    @NonNull
    private String correction;
    @NonNull
    private Integer lessonId;
    @NonNull
    private LocalDate date;
}
