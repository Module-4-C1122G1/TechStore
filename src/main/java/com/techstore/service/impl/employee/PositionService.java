package com.techstore.service.impl.employee;

import com.techstore.model.employee.Position;
import com.techstore.repository.employee.IPositionRepository;
import com.techstore.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {

    @Autowired
    private IPositionRepository iPositionRepository;

    @Override
    public List<Position> findAll() {
        return iPositionRepository.findAll();
    }
}
