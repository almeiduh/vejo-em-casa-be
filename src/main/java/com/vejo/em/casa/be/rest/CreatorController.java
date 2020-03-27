package com.vejo.em.casa.be.rest;

import com.vejo.em.casa.be.entity.Creator;
import com.vejo.em.casa.be.service.CreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/creator")
public class CreatorController {

    @Autowired
    CreatorService service;

    @GetMapping()
    public List<Creator> getAllCreators() { return service.findAll(); }


    @GetMapping(value = "/{id}")
    public Creator getSingleCreator(@PathVariable Long id) { 
       return service.getSingleEvent(id);

    }


    //@PostMapping()
    public Creator saveCreator(Creator creator) {
    	return service.save(creator);
    }

}
