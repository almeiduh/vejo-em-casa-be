package com.vejo.em.casa.be.rest;

import com.vejo.em.casa.be.entity.Creator;
import com.vejo.em.casa.be.service.CreatorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/creator")
public class CreatorController {

    @Autowired
    CreatorService service;

    @GetMapping()
    public List<Creator> getAllCreators() {
        log.debug("Received request to get all creators");
        return service.findAll();
    }


    @GetMapping(value = "/{id}")
    public Creator getSingleCreator(@PathVariable Long id) {
        log.debug("Received request to get creator with id {}", id);
        return service.getSingleCreator(id);
    }


    //@PostMapping()
    public Creator saveCreator(Creator creator) {
        return service.save(creator);
    }

}
