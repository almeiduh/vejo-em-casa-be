package com.vejo.em.casa.be.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "subscribed_users")
public class SubscribedUser {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String email;

    public SubscribedUser() {
    }

    public SubscribedUser(String email) {
        this.email = email;
    }

}
