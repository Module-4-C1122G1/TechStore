package com.techstore.service.impl.employee;

import com.techstore.dto.EmployeeDTO;
import com.techstore.model.employee.Employee;
import com.techstore.repository.employee.IEmployeeRepository;
import com.techstore.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> findAll(String name,PageRequest pageRequest) {
        return iEmployeeRepository.findAllByNameEmployeeContaining(name,pageRequest);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return iEmployeeRepository.findById(id);
    }

    @Override
    public void createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        iEmployeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        iEmployeeRepository.delete(employee);
    }

    @Override
    public void editEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDTO,employee);
        iEmployeeRepository.save(employee);
    }
}
