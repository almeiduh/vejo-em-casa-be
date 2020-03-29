package com.vejo.em.casa.be.rest;

import com.vejo.em.casa.be.entity.Event;
import com.vejo.em.casa.be.service.EventService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@Log4j2
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
        log.debug("Received request to get all events. categoryId: {}, creatorId: {}, after: {}, before: {}, page: {}, size: {}",
                categoryId, creatorId, after, before, page, size);
        return eventService.getAllEvents(categoryId, creatorId, after, before, page, size);
    }

    @GetMapping(value = "/{id}")
    public Event getSigleEvent(@PathVariable() Long id) {
        log.debug("Received request to get event with id {}", id);
        return eventService.getSingleEvent(id);
    }


    //@PostMapping()
    public Event saveEvent(Event event) {
        return eventService.save(event);
    }


}
