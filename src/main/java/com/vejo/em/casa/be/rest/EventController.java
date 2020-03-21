package com.vejo.em.casa.be.rest;


import com.vejo.em.casa.be.entity.Creator;
import com.vejo.em.casa.be.entity.Event;
import com.vejo.em.casa.be.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventRepository repository;

    @GetMapping(value="getAllEvents")
    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    @GetMapping(value = "getSingleEvent")
    public Event getSingleEvent(Long id) { return repository.findById(id).orElse(null); }

}
