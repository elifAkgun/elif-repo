package code.elif.model.withAnnotation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Getter
@Setter
@ToString
@Component("myOrgWithValue")
public class OrganizationWithValues {


    @Value("${company.name}")
    private String companyName;
    @Value("${company.year}")
    private Integer yearOfIncorporation;
    @Value("${company.postcode}")
    private String postalCode;
    @Value("${company.employee.count}")
    private int employeeCount;


    public void postConstruct() {
        System.out.println("Organization : postConstruct  method called.");
    }

    public void preDestroy() {
        System.out.println("Organization : preDestroy method called.");
    }


}
