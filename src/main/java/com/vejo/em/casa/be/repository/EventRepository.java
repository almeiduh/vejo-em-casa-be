package com.vejo.em.casa.be.repository;

import com.vejo.em.casa.be.entity.Event;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
}
