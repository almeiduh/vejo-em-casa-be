package com.vejo.em.casa.be.rest;

import com.vejo.em.casa.be.entity.Creator;
import com.vejo.em.casa.be.repository.CreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/creator")
public class CreatorController {

    @Autowired
    CreatorRepository repository;

    @GetMapping(value="getAllCreators")
    public List<Creator> getAllCreators(){  return repository.findAll(); }

    @GetMapping(value = "getSingleCategory")
    public Creator getSingleCategory(Long id) { return repository.findById(id).orElse(null); }

}
