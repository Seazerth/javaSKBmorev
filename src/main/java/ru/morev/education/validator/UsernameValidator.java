package ru.morev.education.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.morev.education.annotation.ValidUsername;

public class UsernameValidator implements ConstraintValidator<ValidUsername, String> {

    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9._-]{3,20}$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.matches(USERNAME_PATTERN);
    }
}
