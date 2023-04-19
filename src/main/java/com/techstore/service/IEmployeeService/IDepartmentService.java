package com.techstore.service.IEmployeeService;

import com.techstore.model.employee.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> findAll();
}
