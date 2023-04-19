package com.techstore.service.IEmployeeService;

import com.techstore.model.employee.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();
}
