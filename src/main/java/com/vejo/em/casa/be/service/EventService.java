package com.vejo.em.casa.be.service;

import com.vejo.em.casa.be.entity.Event;
import com.vejo.em.casa.be.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;


    /**
     * Get all the events in the database paginated
     *
     * @param page
     * @param size
     * @return List of events paginated and ordered by time to always showns in order
     */
    public List<Event> getAllEventsPaginated(int page, int size, Long creatorId, Long categoryId) {
        Pageable pageable = PageRequest.of(page,  size, Sort.by("time"));
        Page<Event> pageResult = repository.findAll(pageable);

        if(creatorId != null) {
            return this.getAllEventsByCreator(creatorId, pageable);
        } else if (categoryId != null) {
            return this.getAllEventsByCategory(categoryId, pageable);
        }

        return pageResult.toList();
    }

    /**
     * Service responsible to find the event by id
     * @param id
     * @return Event by id
     */
    public Event getSingleEvent(Long id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Save event
     * @param event
     */
    public void save(Event event) {
        repository.save(event);
    }

    /**
     * Get all events by creator id
     * @param creatorId
     * @return List of events recording creator id
     */
    public List<Event> getAllEventsByCreator(Long creatorId, Pageable pageable){

        // return empty list if the creatorId is null
        if(creatorId == null) return null;

        return repository.findAllByCreator_Id(creatorId, pageable);
    }

    /**
     * Get all events by category id
     * @param categoryId
     * @return List of events recording category id
     */
    public List<Event> getAllEventsByCategory(Long categoryId, Pageable pageable){

        // return empty list if the creatorId is null
        if(categoryId == null) return null;

        return repository.findAllByCategory_Id(categoryId, pageable);
    }
}
