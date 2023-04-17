package com.techstore.service.employee;

import com.techstore.model.employee.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();
}
