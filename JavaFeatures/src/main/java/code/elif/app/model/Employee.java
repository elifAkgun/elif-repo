package code.elif.app.model;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    Integer id;
    String name;
    LocalDate startDate;
}
