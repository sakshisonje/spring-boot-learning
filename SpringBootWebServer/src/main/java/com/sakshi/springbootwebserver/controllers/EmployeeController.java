package com.sakshi.springbootwebserver.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping(path="/getSecretMessage")
    public String getMySuperSecretMessage(){
        return "This is the secret message : Getmapping is implemented";
    }
}
