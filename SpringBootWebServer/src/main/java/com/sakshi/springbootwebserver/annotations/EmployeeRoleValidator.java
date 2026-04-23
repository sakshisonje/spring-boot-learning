package com.sakshi.springbootwebserver.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation, String> {
    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext constraintValidatorContext) {
        List<String> roles= List.of("USER","ADMIN", "SDE", "QE", "PO", "SM");
        return roles.contains(inputRole);
    }
}
