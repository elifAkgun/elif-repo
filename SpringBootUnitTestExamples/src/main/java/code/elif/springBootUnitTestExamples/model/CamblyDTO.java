package code.elif.springBootUnitTestExamples.model;

import lombok.*;

import java.time.LocalDate;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CamblyDTO {

    private Long id;
    @NonNull
    private String mistake;
    @NonNull
    private String correction;
    @NonNull
    private Integer lessonId;
    @NonNull
    private LocalDate date;

}
