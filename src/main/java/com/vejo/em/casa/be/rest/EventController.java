package com.vejo.em.casa.be.rest;

import com.vejo.em.casa.be.entity.Event;
import com.vejo.em.casa.be.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping(value="/getAllEvents/{page}/{size}")
    public List<Event> getAllEvents(@PathVariable int page,@PathVariable int size) {
        return eventService.getAllEventsPaginated(page, size);
    }

    @GetMapping(value = "/getSingleEvent/{id}")
    public Event getSigleEvent(@PathVariable Optional<Integer> id) {
        if(id.isPresent()) {
            return eventService.getSingleEvent(id.get().longValue());
        } else {
            return null;
        }
    }

    @PostMapping(value = "save")
    public void saveEvent(Event event) {
        eventService.save(event);
    }
}
