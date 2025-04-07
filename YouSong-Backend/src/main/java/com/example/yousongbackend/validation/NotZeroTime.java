package com.example.yousongbackend.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotZeroTimeValidator.class)
public @interface NotZeroTime {
    String message() default "Time can't be 0 seconds";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
