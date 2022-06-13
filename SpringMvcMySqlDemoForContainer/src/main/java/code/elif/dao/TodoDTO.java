package code.elif.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "MOVIE")
@AllArgsConstructor
@Setter
@Getter
@ToString
public class TodoDTO {

    @Id
    private Long id;
    private String header;
    private String body;
    private LocalDate localDate;
}
