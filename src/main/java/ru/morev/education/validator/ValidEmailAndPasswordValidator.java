package ru.morev.education.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.morev.education.annotation.ValidEmailAndPassword;
import ru.morev.education.dto.UserDto;

import java.util.regex.Pattern;

public class ValidEmailAndPasswordValidator implements ConstraintValidator<ValidEmailAndPassword, UserDto> {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");

    @Override
    public boolean isValid(UserDto userDto, ConstraintValidatorContext context) {
        if (userDto == null) return false;

        // ✅ Теперь UserDto имеет getEmail() и getPassword(), ошибки не будет
        boolean validEmail = EMAIL_PATTERN.matcher(userDto.getEmail()).matches();
        boolean validPassword = userDto.getPassword() != null && userDto.getPassword().length() >= 6;

        return validEmail && validPassword;
    }
}
