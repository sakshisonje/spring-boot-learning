package com.sakshi.springbootwebserver.controllers;

import com.sakshi.springbootwebserver.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

//    @GetMapping(path="/getSecretMessage")
//    public String getMySuperSecretMessage(){
//        return "This is the secret message : Getmapping is implemented";
//    }

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name="employeeId") Long id){
        return new EmployeeDTO(id,"Sakshi Sonje","sak@gmail.com",24, LocalDate.of(2023,10,7),true);
    }
    @GetMapping
    public String getAllEmployees(@RequestParam(required = false) Integer age,
                                  @RequestParam(required = false) String sortBy){
         return "Hi age   "+age+"    "+sortBy;
    }

    /// we cannot directly hit the post request to the browser
    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        inputEmployee.setId(100L);
        return inputEmployee;
    }

    @PutMapping
    String updateEmployeeId(){
        return "Put mapping";
    }

}
