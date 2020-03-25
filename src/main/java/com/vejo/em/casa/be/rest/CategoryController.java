package com.vejo.em.casa.be.rest;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vejo.em.casa.be.entity.Category;
import com.vejo.em.casa.be.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService service;

    @GetMapping()
    public List<Category> getAllCategories(){  return service.findAll(); }


    @GetMapping("{id}")
    public Category getSingleCategory(@PathVariable Long id) {
        return service.getSingleCategory(id);
    }


    @PostMapping()
    public Category save(Category category) { return this.service.save(category); }

}
