package com.vejo.em.casa.be.rest;

import com.vejo.em.casa.be.entity.Category;
import com.vejo.em.casa.be.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService service;

    @GetMapping(value="getAllCategories")
    public List<Category> getAllCategories(){  return service.findAll(); }

    @GetMapping(value = "getSingleCategory/{id}")
    public Category getSingleCategory(@PathVariable Optional<Integer> id) {
        if (id.isPresent()) {
            return service.findById(id.get().longValue());
        } else {
            return null;
        }
    }

    @PostMapping
    public void save(Category category) { this.service.save(category); }
}
