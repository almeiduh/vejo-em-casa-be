package com.vejo.em.casa.be.service;

import com.vejo.em.casa.be.entity.Creator;
import com.vejo.em.casa.be.repository.CreatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreatorService {

    @Autowired
    private CreatorRepository repository;

    public List<Creator> findAll() {
        return repository.findAll();
    }

    public Creator getSingleEvent(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Creator save(Creator creator) {
        return repository.save(creator);
    }
}
