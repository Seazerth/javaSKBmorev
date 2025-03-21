package ru.morev.education.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ru.morev.education.validator.ValidEmailAndPasswordValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidEmailAndPasswordValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmailAndPassword {
    String message() default "Некорректный email или пароль";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
