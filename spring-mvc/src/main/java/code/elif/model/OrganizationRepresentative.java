package code.elif.model;

import code.elif.validation.PhoneValidate;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class OrganizationRepresentative {

    @NotBlank(message = "First name cannot be empty!")
    @Size(min = 3 , max =15, message = "Your name must be between 1 and 15 character!")
    private String firstName;

    @PhoneValidate
    private String phone;

    @NotEmpty(message = "Email must be filled!")
    @Pattern(regexp = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", message = "Invalid email format!")
    private String email;


}
