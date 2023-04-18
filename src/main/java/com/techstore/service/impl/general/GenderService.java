package com.techstore.service.impl.general;

import com.techstore.model.general.Gender;
import com.techstore.repository.general.IGenderRepository;
import com.techstore.service.general.IGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderService implements IGenderService {

    @Autowired
    private IGenderRepository iGenderRepository;

    @Override
    public List<Gender> findAll() {
        return iGenderRepository.findAll();
    }
}
