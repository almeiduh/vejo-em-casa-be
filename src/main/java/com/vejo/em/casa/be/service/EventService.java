package com.vejo.em.casa.be.service;

import com.vejo.em.casa.be.entity.Event;
import com.vejo.em.casa.be.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

        if (creatorId != null && categoryId != null) {
            return this.getAllEventsByCreatorAndCategory(creatorId, categoryId, pageable);
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
     * Get all events by creator AND/OR category id
     * @param creatorId
     * @param categoryId
     * @param pageable
     * @return List of events
     */
    public List<Event> getAllEventsByCreatorAndCategory(Long creatorId, Long categoryId, Pageable pageable){

        if(categoryId == null)
            return repository.findAllByCreator_Id(creatorId, pageable);
        else if (creatorId == null)
            return repository.findAllByCategory_Id(categoryId, pageable);

        return repository.findAllByCreator_idAndCategory_Id(creatorId, categoryId, pageable);
    }
}
