package com.sakshi.springbootwebserver.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Constraint(validatedBy={DepartmentValidator.class})
public @interface DepartmentTitleValidation {
    String message() default "The Title of the department can be IT | HR | Finance";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
