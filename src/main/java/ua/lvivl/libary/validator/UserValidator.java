package ua.lvivl.libary.validator;

/**
 * Created by lembergIP on 04.11.2016.
 */
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public interface UserValidator extends Validator {
    void validateEmail(Object o, Errors errors);
}
