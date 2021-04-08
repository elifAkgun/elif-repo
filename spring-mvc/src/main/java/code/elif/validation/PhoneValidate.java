package code.elif.validation;

import code.elif.validation.implementation.PhoneNumberValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = PhoneNumberValidation.class)
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PhoneValidate {

    String message() default "Invalid Phone Number!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
