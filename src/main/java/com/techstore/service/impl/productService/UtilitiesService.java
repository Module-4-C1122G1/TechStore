package com.techstore.service.impl.productService;

import com.techstore.model.product.Utilities;
import com.techstore.repository.productRepository.IUtilitiesRepository;
import com.techstore.service.IProductService.IUtilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UtilitiesService implements IUtilitiesService {
    @Autowired
    private IUtilitiesRepository utilitiesRepository;
    @Override
    public List<Utilities> findAll() {
        return utilitiesRepository.findAll();
    }

    @Override
    public Utilities findById(int id) {
        return utilitiesRepository.findById(id).get();
    }
}
