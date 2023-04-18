package com.techstore.service.impl.employee;

import com.techstore.model.employee.Department;
import com.techstore.repository.employee.IDepartmentRepository;
import com.techstore.service.employee.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private IDepartmentRepository iDepartmentRepository;

    @Override
    public List<Department> findAll() {
        return iDepartmentRepository.findAll();
    }
}
