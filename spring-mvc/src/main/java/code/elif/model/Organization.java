package code.elif.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component("myOrg")
@RequiredArgsConstructor
@NoArgsConstructor
public class Organization {
    private Integer id;
    @NonNull
    private String companyName;
    @NonNull
    private Integer yearOfIncorporation;
    @NonNull
    private String postalCode;
    @NonNull
    private int employeeCount;
    @NonNull
    private String slogan;
}
