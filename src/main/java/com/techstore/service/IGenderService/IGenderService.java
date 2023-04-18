package com.techstore.service.IGenderService;

import com.techstore.model.general.Gender;

import java.util.List;

public interface IGenderService {
    List<Gender> findAll();
    Gender findById(int id);
}
