package com.sakshi.springbootwebserver.services;

import com.sakshi.springbootwebserver.dto.DepartmentDTO;
import com.sakshi.springbootwebserver.dto.EmployeeDTO;
import com.sakshi.springbootwebserver.entities.DepartmentEntity;
import com.sakshi.springbootwebserver.entities.EmployeeEntity;
import com.sakshi.springbootwebserver.repositeries.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;  //service needs DB operations
    private final ModelMapper modelMapper;


    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> departmentEntities=departmentRepository.findAll();
        return departmentEntities
                .stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class))
                .collect(Collectors.toList());
    }
    public Optional<DepartmentDTO> getDepartmentById(Long id){

    }
}
