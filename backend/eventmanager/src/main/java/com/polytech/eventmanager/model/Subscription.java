package com.polytech.eventmanager.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subscriptions")
public class Subscription {

    @EmbeddedId
    private SubscriptionId id = new SubscriptionId();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("eventId")
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "ticket_number", columnDefinition = "BIGINT(20) NOT NULL UNIQUE KEY auto_increment")
    private Long ticketNumber;

    @Column(name = "date_of_order", nullable = false)
    private Date dateOfOrder;

}
