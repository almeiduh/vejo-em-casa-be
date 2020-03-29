
package com.vejo.em.casa.be.service;

import com.vejo.em.casa.be.entity.Event;
import com.vejo.em.casa.be.entity.Event_;
import com.vejo.em.casa.be.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    /**
     * Get all the events in the database paginated
     * @param categoryId
     * @param creatorId
     * @param after
     * @param before
     * @param highlight
     * @param page
     * @param size
     * @return List of events paginated and ordered by time to always showns in order
     */
    public Page<Event> getAllEvents(Long categoryId,
    		                        Long creatorId,
    		                        LocalDateTime after,
    		                        LocalDateTime before,
    		                        Boolean highlight,
    		                        int page,
    		                        int size) {

    	Pageable pageable = PageRequest.of(page,  size, Sort.by("time"));
        return repository.findAll(
        		Specification.where(hasCategoryId(categoryId))
        		             .and(hasCreatorId(creatorId))
        		             .and(afterDate(after))
        		             .and(beforeDate(before))
        		             .and(isHighLight(highlight))
        		, pageable);
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
    public Event save(Event event) {
        return repository.save(event);
    }

    ////////////////////////////////////////////////
    /// Specifications for Events                //
    ///////////////////////////////////////////////



    
    /**
     *
     * @param before
     * @return
     */
    static Specification<Event> beforeDate(LocalDateTime before) {
    	if(before == null) return (event, cq, cb) -> null;

        return (event, cq, cb) -> cb.lessThanOrEqualTo(event.get(Event_.time), before);
    }

    /**
     *
     * @param after
     * @return
     */
    static Specification<Event> afterDate(LocalDateTime after) {
    	if(after == null) return (event, cq, cb) -> null;

        return (event, cq, cb) -> cb.greaterThanOrEqualTo(event.get(Event_.time), after);
    }

    /**
     * 
     * @param categoryId can be {@literal null}.
     * @return
     */
    static Specification<Event> hasCategoryId(Long categoryId) {
    	if(categoryId == null) return (event, cq, cb) -> null;
    	
        return (event, cq, cb) -> cb.equal(event.get(Event_.category), categoryId);
    }
    
    /**
     * 
     * @param creatorId can be {@literal null}.
     * @return
     */
    static Specification<Event> hasCreatorId(Long  creatorId) {
    	if(creatorId == null) return (event, cq, cb) -> null;
    	return (event, cq, cb) -> cb.equal(event.get(Event_.creator), creatorId);
    }

    static Specification<Event> isHighLight(Boolean highlight) {
    	if(highlight == null) return (event, cq, cb) -> null;

        return (event, cq, cb) -> cb.equal(event.get(Event_.isHighlight), highlight);
    }
    
}
