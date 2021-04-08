package code.elif.validation.implementation;

import code.elif.validation.PhoneValidate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PhoneNumberValidation implements ConstraintValidator<PhoneValidate, String> {

    String message;

    @Override
    public void initialize(PhoneValidate phoneValidate) {
        message = phoneValidate.message();
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile("^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        if(matcher.matches()) {
            return true;
        }
        return false;
    }
}
