package com.techstore.repository.employee;

import com.techstore.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    Page<Employee> findAllByNameEmployeeContaining(String name,Pageable pageable);
}
