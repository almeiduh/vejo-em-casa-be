package com.vejo.em.casa.be.rest;

import com.vejo.em.casa.be.entity.Category;
import com.vejo.em.casa.be.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository repository;

    @GetMapping(value="getAllCategories")
    public List<Category> getAllCategories(){  return repository.findAll(); }

    @GetMapping(value = "getSingleCategory")
    public Category getSingleCategory(Long id) { return repository.findById(id).orElse(null); }

}
