package com.sakshi.springbootwebserver.controllers;

import com.sakshi.springbootwebserver.dto.EmployeeDTO;
import com.sakshi.springbootwebserver.entities.EmployeeEntity;
import com.sakshi.springbootwebserver.repositeries.EmployeeRepository;
import com.sakshi.springbootwebserver.services.EmployeeService;
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

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name="employeeId") Long id){
        return employeeService.getEmployeeById(id);
    }
    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
                                @RequestParam(required = false) String sortBy){
         return employeeService.getAllEmployees();
    }

    /// we cannot directly hit the post request to the browser
    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
//        inputEmployee.setId(100L);
        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping
    String updateEmployeeId(){
        return "Put mapping";
    }

}
