package elif.code.model.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

    private final Environment environment;

    @Autowired
    public OrganizationWithValues(Environment environment) {
        this.environment = environment;
    }

    public String getMySlogan(){
        return environment.getProperty("company.slogan");
    }
}
