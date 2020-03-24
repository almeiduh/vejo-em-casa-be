package com.vejo.em.casa.be.rest;

import com.vejo.em.casa.be.entity.Event;
import com.vejo.em.casa.be.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping(value="/getAllEvents")
    public List<Event> getAllEvents(@RequestParam int page,@RequestParam int size, @RequestParam("creatorId") Long creatorId, @RequestParam("categoryId") Long categoryId) {
        return eventService.getAllEventsPaginated(page, size, creatorId, categoryId);
    }

    @GetMapping(value = "/getSingleEvent")
    public Event getSigleEvent(@RequestParam("eventId") Long id) {
        return eventService.getSingleEvent(id);
    }
}
