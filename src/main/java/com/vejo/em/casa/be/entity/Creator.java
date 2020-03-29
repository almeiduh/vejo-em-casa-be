package com.vejo.em.casa.be.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Cacheable(false)
@Entity(name = "creator")
public class Creator {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "donation_url")
    private String donationUrl;

    @Column(name = "email")
    private String email;

    @Column(name = "photo")
    private String photo;

}
