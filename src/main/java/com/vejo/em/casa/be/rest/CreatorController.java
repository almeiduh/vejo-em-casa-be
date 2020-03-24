package com.vejo.em.casa.be.rest;

import com.vejo.em.casa.be.entity.Creator;
import com.vejo.em.casa.be.service.CreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/creator")
public class CreatorController {

    @Autowired
    CreatorService service;

    @GetMapping(value="getAllCreators")
    public List<Creator> getAllCreators() { return service.findAll(); }

    @GetMapping(value = "getSingleCreator/{id}")
    public Creator getSingleCreator(@RequestParam(value = "creatorId") Long creatorId) {
        return service.getSingleEvent(creatorId);
    }
}
