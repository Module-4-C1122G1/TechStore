package com.techstore.service.IEmployeeService;

import com.techstore.dto.EmployeeDTO;
import com.techstore.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface IEmployeeService {

    Page<Employee> findAll(String name,PageRequest pageRequest);

    Optional<Employee> findById(int id);

    void createEmployee(EmployeeDTO employeeDTO);

    void deleteEmployee(Employee employee);

    void editEmployee(EmployeeDTO employeeDTO);
}
