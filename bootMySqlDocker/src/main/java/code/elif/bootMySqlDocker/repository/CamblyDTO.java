package code.elif.bootMySqlDocker.repository;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity (name = "cambly")
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
