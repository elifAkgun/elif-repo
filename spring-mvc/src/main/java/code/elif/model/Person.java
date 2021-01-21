package code.elif.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Component("person")
public class Person {

    private Integer id;

    @NonNull
    private String name;
    @NonNull
    private String surName;
    @NonNull
    private LocalDate birthDate;

}
