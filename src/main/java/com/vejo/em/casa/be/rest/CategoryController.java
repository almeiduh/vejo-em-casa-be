package com.vejo.em.casa.be.rest;

import com.vejo.em.casa.be.entity.Category;
import com.vejo.em.casa.be.service.CategoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService service;

    @GetMapping()
    public List<Category> getAllCategories() {
        log.debug("Received request to get all categories");
        return service.findAll();
    }


    @GetMapping("{id}")
    public Category getSingleCategory(@PathVariable Long id) {
        log.debug("Received request to get category with id {}", id);
        return service.getSingleCategory(id);
    }


    //@PostMapping()
    public Category save(Category category) { return this.service.save(category); }

}
