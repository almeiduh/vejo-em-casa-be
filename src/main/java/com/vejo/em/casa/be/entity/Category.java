package com.vejo.em.casa.be.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Cacheable(false)
@Entity(name = "category")
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

}
