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

    @GetMapping(value = "/getSingleEvent")
    public Event getSigleEvent(@RequestParam("eventId") Long id) {
        return eventService.getSingleEvent(id);
    }

    @PostMapping(value = "save")
    public void saveEvent(Event event) {
        eventService.save(event);
    }

    @GetMapping(value = "/getAllEventsByCreator")
    @ResponseBody
    public List<Event> getAllEventsByCreator(@RequestParam("creatorId") Long creatorId) {
        return eventService.getAllEventsByCreator(creatorId);
    }

    @GetMapping(value = "/getAllEventsByCategory")
    @ResponseBody
    public List<Event> getAllEventsByCategory(@RequestParam("categoryId") Long categoryId) {
        return eventService.getAllEventsByCategory(categoryId);
    }
}
