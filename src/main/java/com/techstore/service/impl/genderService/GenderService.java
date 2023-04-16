package com.techstore.service.impl.genderService;

import com.techstore.model.general.Gender;
import com.techstore.repository.genderRepository.IGenderRepository;
import com.techstore.service.IGenderService.IGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenderService implements IGenderService {
    @Autowired
    private IGenderRepository genderRepository;
    @Override
    public List<Gender> findAll() {
        return genderRepository.findAll();
    }

    @Override
    public Gender findById(int id) {
        return genderRepository.findById(id).get();
    }
}
