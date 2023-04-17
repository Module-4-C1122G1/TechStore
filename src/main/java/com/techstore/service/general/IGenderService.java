package com.techstore.service.general;

import com.techstore.model.general.Gender;

import java.util.List;

public interface IGenderService {
    List<Gender> findAll();
}
