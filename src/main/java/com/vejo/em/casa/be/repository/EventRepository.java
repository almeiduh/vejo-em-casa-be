package com.vejo.em.casa.be.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.vejo.em.casa.be.entity.Event;


@Repository
public interface EventRepository extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event> {

	
	
	
    /**
     * Find all the events by creator
     * @param creatorId
     * @return List of events
     */
    List<Event> findAllByCreator_Id(Long creatorId, Pageable pageable);

    /**
     * Find All the events by category
     * @param categoryId
     * @return
     */
    List<Event> findAllByCategory_Id(Long categoryId, Pageable pageable);

    /**
     * Find All the events by category
     * @param categoryId
     * @return
     */
    List<Event> findAllByCreator_idAndCategory_Id(Long creatorId, Long categoryId, Pageable pageable);
}
