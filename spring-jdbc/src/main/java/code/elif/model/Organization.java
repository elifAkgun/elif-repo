package code.elif.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component("myOrg")
public class Organization {
    private Integer id;
    private String companyName;
    private Integer yearOfIncorporation;
    private String postalCode;
    private int employeeCount;
    private String slogan;
}
