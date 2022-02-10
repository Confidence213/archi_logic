package com.polytech.eventmanager.model;

import java.util.Date;

import lombok.*;
import javax.persistence.*;

@Entity // mark class as a database entity
@Getter // specify separatly lombok annotation instead of @Data to avoid some problems
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "event") // name of database table

public class Event {

    @Id // annotation for ID column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy for ID, here it well be ID++
    @Column(length = 11) // column size on database side definition
    private Integer id;

    @Column(name = "name", nullable = false, length = 45) // database definiton => will launch SQL exception
    // NB: words in name should be linked by underscore => name_of_column
    private String name;

    @Column(name = "Description", length = 100)
    public String Description;

    @Column(name = "Lieu", nullable = false, length = 15)
    public String Place;

    @Column(name= "MaxOfParticipant", length = 9999)
    private int MaxOfParticipant;

    @Column(name = "Price")
    private float Price;

    @Column(name = "dateOfEvent")
    private Date dateOfEvent;
}