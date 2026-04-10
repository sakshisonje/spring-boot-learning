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
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId){
        return new EmployeeDTO(employeeId,"Sakshi Sonje","sak@gmail.com",24, LocalDate.of(2023,10,7),true);
    }
    @GetMapping
    public String getAllEmployees(@RequestParam(required = false) Integer age,
                                  @RequestParam(required = false) String sortBy){
         return "Hi age   "+age+"    "+sortBy;
    }
}
