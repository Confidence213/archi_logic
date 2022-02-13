package com.polytech.eventmanager.repository;

import com.polytech.eventmanager.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    @Query(value = "select s.* from subscriptions s where s.ticket_number= :ticketNumber", nativeQuery = true)
    Optional<Subscription> findByTicketNumber(@Param("ticketNumber") Long ticketNumber);

    @Query(value = "select s.* from subscriptions s where s.user_id= :userId and s.event_id= :eventId", nativeQuery = true)
    Optional<Subscription> findById(@Param("userId") Long userId, @Param("eventId") Long eventId);

    @Query(value = "delete s.* from subscriptions s where s.ticket_number= :ticketNumber", nativeQuery = true)
    void deleteByTicketNumber(@Param("ticketNumber") Long ticketNumber);

    @Query(value = "select count(*) from subscriptions s where s.event_id= :eventId", nativeQuery = true)
    Integer findNumberOfParticipantsForEvent(@Param("eventId") Long eventId);

    @Query(value = "select s.event_id from subscriptions s where s.user_username= :username", nativeQuery = true)
    List<Long> findOrderedEventsByUser(@Param("username") String username);

}