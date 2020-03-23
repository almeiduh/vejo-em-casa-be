package com.vejo.em.casa.be.rest;

import com.vejo.em.casa.be.entity.Creator;
import com.vejo.em.casa.be.service.CreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/creator")
public class CreatorController {

    @Autowired
    CreatorService service;

    @GetMapping(value="getAllCreators")
    public List<Creator> getAllCreators() { return service.findAll(); }

    @GetMapping(value = "getSingleCreator/{id}")
    public Creator getSingleCreator(@PathVariable Optional<Integer> id) {
        if (id.isPresent()) {
            return service.findById(id.get().longValue());
        } else {
            return null;
        }
    }

    @PostMapping(value = "saveEvent")
    public void saveCreator(Creator creator) { service.save(creator); }
}
