package com.sakshi.springbootwebserver.services;

import com.sakshi.springbootwebserver.repositeries.DepartmentRepository;
import com.sakshi.springbootwebserver.repositeries.EmployeeRepository;
import org.modelmapper.ModelMapper;

public class DepartmentService {
    private final DepartmentRepository departmentRepository;  //service needs DB operations
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
}
