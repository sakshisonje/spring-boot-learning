package com.sakshi.springbootwebserver.controllers;

import com.sakshi.springbootwebserver.dto.EmployeeDTO;
import com.sakshi.springbootwebserver.entities.EmployeeEntity;
import com.sakshi.springbootwebserver.repositeries.EmployeeRepository;
import com.sakshi.springbootwebserver.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

//    @GetMapping(path="/getSecretMessage")
//    public String getMySuperSecretMessage(){
//        return "This is the secret message : Getmapping is implemented";
//    }

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name="employeeId") Long id){
        Optional<EmployeeDTO> employeeDTO=employeeService.getEmployeeById(id);
        return employeeDTO.map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
                                @RequestParam(required = false) String sortBy){
         return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    /// we cannot directly hit the post request to the browser
    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
//        inputEmployee.setId(100L);
        EmployeeDTO savedEmployee=employeeService.createNewEmployee(inputEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeId(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId){
        return  ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, employeeDTO));
    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeId(@PathVariable Long employeeId){
        boolean gotDeleted= employeeService.deleteEmployeeById(employeeId);
        if(gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeId(@RequestBody Map<String,Object> updates,
                                               @PathVariable Long employeeId){
        EmployeeDTO employeeDTO= employeeService.updatePartialEmployeeId(employeeId, updates);
        if(employeeDTO==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }

}
