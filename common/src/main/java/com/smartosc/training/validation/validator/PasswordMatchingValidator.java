package com.smartosc.training.validation.validator;

import com.smartosc.training.dto.UserDTO;
import com.smartosc.training.validation.ValidMatchingPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchingValidator
        implements ConstraintValidator<ValidMatchingPassword, Object> {

    @Override
    public void initialize(ValidMatchingPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        UserDTO user = (UserDTO) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }

}
