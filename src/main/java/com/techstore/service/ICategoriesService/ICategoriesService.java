package com.techstore.service.ICategoriesService;

import com.techstore.model.categories.Categories;

import java.util.List;

public interface ICategoriesService {
    List<Categories> findAll();
    Categories findById(int id);
    Categories findCategoriesById(int id);
}
