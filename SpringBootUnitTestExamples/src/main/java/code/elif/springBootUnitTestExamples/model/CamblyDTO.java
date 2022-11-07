package code.elif.springBootUnitTestExamples.model;

import code.elif.springBootUnitTestExamples.repository.model.Cambly;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CamblyDTO {

    @NonNull
    private String mistake;
    @NonNull
    private String correction;
    @NonNull
    private Integer lessonId;
    @NonNull
    private LocalDate date;

}
