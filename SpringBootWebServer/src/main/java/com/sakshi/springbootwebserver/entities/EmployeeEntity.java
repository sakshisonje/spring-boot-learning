package com.sakshi.springbootwebserver.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity  //Java class to be converted into Table
@Table(name="employees")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;
    private Boolean isActive;


}
