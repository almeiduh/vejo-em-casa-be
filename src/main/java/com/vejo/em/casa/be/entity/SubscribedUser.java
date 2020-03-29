package com.vejo.em.casa.be.entity;

import javax.persistence.*;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
