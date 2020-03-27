package com.vejo.em.casa.be.repository;

import com.vejo.em.casa.be.entity.Creator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatorRepository extends JpaRepository<Creator, Long> { }
