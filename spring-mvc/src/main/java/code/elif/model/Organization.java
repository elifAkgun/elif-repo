package code.elif.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

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
    @NonNull
    private ArrayList<String> benefits;
    @NonNull
    private String city;
    @NonNull
    private Integer managerCount;
}
