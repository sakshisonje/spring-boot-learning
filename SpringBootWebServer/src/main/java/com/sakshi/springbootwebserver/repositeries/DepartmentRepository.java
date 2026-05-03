package com.sakshi.springbootwebserver.repositeries;

import com.sakshi.springbootwebserver.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentRepository, Long> {
}
