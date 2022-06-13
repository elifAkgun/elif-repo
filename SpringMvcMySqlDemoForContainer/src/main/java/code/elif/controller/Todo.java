package code.elif.controller;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component("todo")
public class Todo {
    private String header;
    private String body;
    private LocalDate localDate;
}
