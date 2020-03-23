package com.vejo.em.casa.be.repository;

import com.vejo.em.casa.be.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
