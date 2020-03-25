package com.vejo.em.casa.be.service;

import com.vejo.em.casa.be.entity.Category;
import com.vejo.em.casa.be.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category getSingleCategory(Long id) {
        return repository.findById(id).orElse(null);
    }


    public Category save(Category category) {
        return repository.save(category);
    }

}
