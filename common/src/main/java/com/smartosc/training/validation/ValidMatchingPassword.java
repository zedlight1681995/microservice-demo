package com.smartosc.training.validation;

import com.smartosc.training.validation.validator.PasswordMatchingValidator;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordMatchingValidator.class)
@Documented
public @interface ValidMatchingPassword {

    String message() default "Confirm password don't match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
