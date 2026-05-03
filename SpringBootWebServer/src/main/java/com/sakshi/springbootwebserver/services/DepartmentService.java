package com.sakshi.springbootwebserver.services;

import com.sakshi.springbootwebserver.dto.DepartmentDTO;
import com.sakshi.springbootwebserver.entities.DepartmentEntity;
import com.sakshi.springbootwebserver.exception.ResourceNotFoundException;
import com.sakshi.springbootwebserver.repositeries.DepartmentRepository;
import jakarta.validation.Valid;
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
        //department entity into department dto conversion through model mapper
        return departmentRepository.findById(id).map(
                departmentEntity1 ->
                        modelMapper.map(departmentEntity1, DepartmentDTO.class));
    }

    public DepartmentDTO createNewDepartment(@Valid DepartmentDTO departmentDTO) {
        DepartmentEntity toSaveEntity=modelMapper.map(departmentDTO, DepartmentEntity.class);
        DepartmentEntity savedDepartment= departmentRepository.save(toSaveEntity);
        return modelMapper.map(savedDepartment, DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartmentById(@Valid DepartmentDTO departmentDTO, Long departmentId) {
        isExistsByDepartmentId(departmentId);
        DepartmentEntity departmentEntity=modelMapper.map(departmentDTO, DepartmentEntity.class);
        departmentEntity.setId(departmentId);
        DepartmentEntity updatedEmployeeEntity=departmentRepository.save(departmentEntity);
        return modelMapper.map(updatedEmployeeEntity,DepartmentDTO.class);
    }

    private void isExistsByDepartmentId(Long departmentId) {
        boolean exists=departmentRepository.existsById(departmentId);
        if(!exists) throw new ResourceNotFoundException("Employee Not Found with id: "+departmentId);

    }

    public boolean deleteDepartmentById(Long departmentId) {
        isExistsByDepartmentId(departmentId);
        departmentRepository.deleteById(departmentId);
        return true;
    }
}
