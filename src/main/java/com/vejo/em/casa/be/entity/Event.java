package com.vejo.em.casa.be.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Locale;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "approved")
    private Boolean approved;

    @OneToOne
    @Fetch(FetchMode.SELECT)
    @JoinColumn(unique = true)
    private Category category;

    @OneToOne
    @Fetch(FetchMode.SELECT)
    @JoinColumn(unique = true)
    private Creator creator;

    @Column(name = "stream_url")
    private String streamUrl;

    @Column(name = "event_time")
    private LocalDateTime time;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Creator getCreator() {
        return creator;
    }

    public void setCreator(Creator creator) {
        this.creator = creator;
    }

    public String getStreamUrl() {
        return streamUrl;
    }

    public void setStreamUrl(String streamUrl) {
        this.streamUrl = streamUrl;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
