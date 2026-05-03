package com.sakshi.springbootwebserver.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data //getters and setters
@NoArgsConstructor //Hibernate internally needs: default constructor
@AllArgsConstructor //Hibernate internally needs: default constructor
@Table(name="departments")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Boolean isActive;
    private LocalDate createdAt;
}
