package code.elif.bootMySqlDocker.repository;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity (name = "cambly")
public class CamblyDTO {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;

        @NonNull
        private String mistake;
        @NonNull
        private String correction;
        @NonNull
        private Integer lessonId;
        @NonNull
        private LocalDate date;

    }

