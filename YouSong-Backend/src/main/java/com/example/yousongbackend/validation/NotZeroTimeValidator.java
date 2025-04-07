package com.example.yousongbackend.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalTime;

public class NotZeroTimeValidator implements ConstraintValidator<NotZeroTime, LocalTime> {

    @Override
    public boolean isValid(LocalTime value, ConstraintValidatorContext context) {
        return value != null && !value.equals(LocalTime.MIDNIGHT);
    }

    @Override
    public void initialize(NotZeroTime constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}