package com.sakshi.springbootwebserver.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class DepartmentValidator implements ConstraintValidator<DepartmentTitleValidation, String>
{
    @Override
    public boolean isValid(String inputDepartment, ConstraintValidatorContext constraintValidatorContext) {
        if(inputDepartment==null) return false;
        List<String> roles= List.of("Technology","Operations");
        return roles.contains(inputDepartment);
    }
}
