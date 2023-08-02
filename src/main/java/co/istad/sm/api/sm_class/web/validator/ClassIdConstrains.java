package co.istad.sm.api.sm_class.web.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ClassIdConstrainsValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ClassIdConstrains {
    String message() default "Class ID is not existed!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
