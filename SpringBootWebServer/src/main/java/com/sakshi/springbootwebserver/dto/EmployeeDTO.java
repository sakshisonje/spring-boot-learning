package com.sakshi.springbootwebserver.dto;

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
public class EmployeeDTO {

    private Long id;
    @NotBlank(message = "Name cannot be blank")
    @Size(min=3, max=10, message="Number of characters should be in range : 3 to 10")
    private String name;

    @Email(message = "Please enter the Valid Email Id")
    private String email;

    @Max(value = 70, message = "Age of Employee cannot be greater than 70")
    @Min(value = 19, message = "Age of Employee cannot be lesser than 19")
    private Integer age;

    @NotBlank(message = "Role of the Employee cannot be blank")
//    @Pattern(regexp = "^(ADMIN|USER)$",message = "Role must be USER or ADMIN")

    private String role;

    @NotNull @Positive(message = "Salary of Employee should be Positive")
    @Digits(integer = 6, fraction=2,message="Salary can be in the form of XXXXX.XX")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "1000.22")
    private Double salary;

    @PastOrPresent(message = "Date should be past or present")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active")
    private Boolean isActive;

}
