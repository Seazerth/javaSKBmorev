package ru.morev.education.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ru.morev.education.validator.UsernameValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UsernameValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUsername {
    String message() default "{username.invalid}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
