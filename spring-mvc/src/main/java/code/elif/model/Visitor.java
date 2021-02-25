package code.elif.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component("visitorData")
public class Visitor implements Serializable {
    @NonNull
    private Integer id;
    @NonNull
    private String name;
    @NonNull
    private String email;
}
