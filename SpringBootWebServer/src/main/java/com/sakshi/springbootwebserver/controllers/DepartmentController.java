package com.sakshi.springbootwebserver.controllers;

import com.sakshi.springbootwebserver.dto.DepartmentDTO;
import com.sakshi.springbootwebserver.exception.ResourceNotFoundException;
import com.sakshi.springbootwebserver.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path="/departments")
public class DepartmentController {

    private final DepartmentService departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {

        return ResponseEntity.ok(
                departmentService.getAllDepartments()
        );
    }
    @GetMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(
            @PathVariable(name="departmentId") Long id){
        Optional<DepartmentDTO> departmentDTO= departmentService.getDepartmentById(id);
        return departmentDTO
                .map(departmentDTO1 -> ResponseEntity.ok(departmentDTO1))
                .orElseThrow(()->new ResourceNotFoundException("Employee not found with id: "+id));

    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createNewDepartment(@RequestBody @Valid DepartmentDTO departmentDTO)
    {
        DepartmentDTO savedDepartment=departmentService.createNewDepartment(departmentDTO);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }
    @PutMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> updateEmployeeId(@RequestBody @Valid DepartmentDTO departmentDTO, @PathVariable Long departmentId){
        return ResponseEntity.ok(departmentService.updateDepartmentById(departmentDTO,departmentId));
    }

    @DeleteMapping(path = "/{departmentId}")
    public ResponseEntity<Boolean> deleteDepartmentById(@PathVariable Long departmentId)
    {
        boolean gotDeleted=departmentService.deleteDepartmentById(departmentId);
        if(gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }
    @PatchMapping(path = "/{departmentId}")
    public ResponseEntity<DepartmentDTO> updatePartialDepartment(@PathVariable Long departmentId,
                                                                 @RequestBody Map<String,Object> updates)
    {
        DepartmentDTO updatePartialDepartment=departmentService.updatePartialDepartmentById(departmentId,updates);
        if(updatePartialDepartment==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatePartialDepartment);
    }
}
