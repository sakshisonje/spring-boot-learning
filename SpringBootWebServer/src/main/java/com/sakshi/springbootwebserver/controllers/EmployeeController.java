package com.sakshi.springbootwebserver.controllers;

import com.sakshi.springbootwebserver.dto.EmployeeDTO;
import com.sakshi.springbootwebserver.entities.EmployeeEntity;
import com.sakshi.springbootwebserver.repositeries.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

//    @GetMapping(path="/getSecretMessage")
//    public String getMySuperSecretMessage(){
//        return "This is the secret message : Getmapping is implemented";
//    }

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name="employeeId") Long id){
        return employeeRepository.findById(id).orElse(null);
    }
    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
                                @RequestParam(required = false) String sortBy){
         return employeeRepository.findAll();
    }

    /// we cannot directly hit the post request to the browser
    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
//        inputEmployee.setId(100L);
        return employeeRepository.save(inputEmployee);
    }

    @PutMapping
    String updateEmployeeId(){
        return "Put mapping";
    }

}
