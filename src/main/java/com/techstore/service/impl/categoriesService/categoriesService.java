package com.techstore.service.impl.categoriesService;

import com.techstore.model.categories.Categories;
import com.techstore.repository.categoryRepository.ICategoriesRepository;
import com.techstore.service.ICategoriesService.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class categoriesService implements ICategoriesService {
    @Autowired
    private ICategoriesRepository categoriesRepository;
    @Override
    public List<Categories> findAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public Categories findById(int id) {
        return categoriesRepository.findById(id).get();
    }
}
