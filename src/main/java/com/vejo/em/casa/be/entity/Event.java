package com.vejo.em.casa.be.entity;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Cacheable(false)
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "approved")
    private Boolean approved;

    @OneToOne
    @Fetch(FetchMode.SELECT)
    @JoinColumn
    private Category category;

    @OneToOne
    @Fetch(FetchMode.SELECT)
    @JoinColumn
    private Creator creator;

    @Column(name = "description")
    private String description;

    @Column(name = "stream_url")
    private String streamUrl;

    @Column(name = "title")
    private String title;

    @Column(name = "event_time")
    private LocalDateTime time;

    @Lob
    @Column(name = "thumbnail", columnDefinition="BLOB")
    private byte[] thumbnail;

    @Lob
    @Column(name = "highlightImg", columnDefinition="BLOB")
    private byte[] highlightImg;

}
