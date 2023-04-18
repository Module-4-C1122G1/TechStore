package com.techstore.repository.employee;

import com.techstore.model.employee.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department,Integer> {

}
