package code.elif.springBootUnitTestExamples.repository.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity(name = "camblyDTO")
@Table(name = "CAMBLY")
public class Cambly {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

