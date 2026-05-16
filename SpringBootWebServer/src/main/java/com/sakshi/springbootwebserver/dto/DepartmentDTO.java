package com.sakshi.springbootwebserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sakshi.springbootwebserver.annotations.DepartmentTitleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    @Null(message = "ID should be null while creating")
    private Long id;

    @NotBlank(message = "Title cannot be blank")
    @DepartmentTitleValidation
    private String title;

    @AssertTrue(message = "Department must be active")
    @JsonProperty("isActive")
    private Boolean isActive;

    @PastOrPresent
    private LocalDate createdAt;
}
