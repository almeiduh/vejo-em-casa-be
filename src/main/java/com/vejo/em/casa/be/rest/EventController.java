package com.vejo.em.casa.be.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vejo.em.casa.be.entity.Event;
import com.vejo.em.casa.be.service.EventService;


@RestController()
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventService eventService;


    @GetMapping()
    public Page<Event> getAllEvents(
    		@RequestParam(required = false) Long categoryId,
    		@RequestParam(required = false) Long creatorId,
    		@RequestParam(required = false) LocalDateTime after,
    		@RequestParam(required = false) LocalDateTime before,
    		@RequestParam(defaultValue = "0") int page,
    		@RequestParam(defaultValue = "10") int size) {
//        return eventService.getAllEventsPaginated(page, size);
    	
    	return eventService.getAllEvents(categoryId, creatorId, after, before, page, size);
    }

    @GetMapping(value = "/{id}")
    public Event getSigleEvent(@PathVariable() Long id) {
        return eventService.getSingleEvent(id);
    }


    @PostMapping()
    public Event saveEvent(Event event) {
        return eventService.save(event);
    }

    
}
