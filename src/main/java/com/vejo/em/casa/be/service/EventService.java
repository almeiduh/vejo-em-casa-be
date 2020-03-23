package com.vejo.em.casa.be.service;

import com.vejo.em.casa.be.entity.Event;
import com.vejo.em.casa.be.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    public List<Event> getAllEventsPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page,  size);
        Page<Event> pageResult = repository.findAll(pageable);
        return pageResult.toList();
    }

    public Event getSingleEvent(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void save(Event event) {
        repository.save(event);
    }
}
