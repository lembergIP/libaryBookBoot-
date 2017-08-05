package ua.lvivl.libary.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import ua.lvivl.libary.constants.ValidationConstans;
import ua.lvivl.libary.entity.User;
import ua.lvivl.libary.service.UserService;


@Component("userValidator")
public class UserValidatorImpls implements UserValidator{
    @Autowired
    private UserService userService;

    @Override
    public void validateEmail(Object o, Errors errors) {
        String email = (String) o;
        if (userService.findUserByEmail(email) == null) {
            errors.rejectValue(ValidationConstans.EMAIL, ValidationConstans.USER_NOT_EXIST);
        }

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
