package com.techstore.repository.general;

import com.techstore.model.general.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenderRepository extends JpaRepository<Gender,Integer> {
}
