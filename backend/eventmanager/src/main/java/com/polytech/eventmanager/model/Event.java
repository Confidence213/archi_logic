package com.polytech.eventmanager.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", length = 300)
    private String description;

    @Column(name = "place", nullable = false, length = 45)
    private String place;

    @Column(name = "date", nullable = false)
    protected Date date;

    @Column(name = "price", nullable = false, length = 11)
    private Integer price;

    @OneToMany(mappedBy = "event")
    private Set<Subscription> participants;

}