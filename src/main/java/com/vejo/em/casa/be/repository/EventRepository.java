package com.vejo.em.casa.be.repository;

import com.vejo.em.casa.be.entity.Event;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {

    /**
     * Find all the events by creator
     * @param creatorId
     * @return List of events
     */
    List<Event> findAllByCreator_Id(Long creatorId);

    /**
     * Find All the events by category
     * @param categoryId
     * @return
     */
    List<Event> findAllByCategory_Id(Long categoryId);
}
