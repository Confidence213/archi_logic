package com.polytech.eventmanager.repository;

import com.polytech.eventmanager.model.Subscription;
import com.polytech.eventmanager.model.SubscriptionId;
import com.polytech.eventmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, SubscriptionId> {

    @Query(value = "select s.* from subscriptions s where s.user_id = :userId and s.event_id = :eventId", nativeQuery = true)
    Optional<Subscription> findById(@Param("userId") Long userId, @Param("eventId") Long eventId);

    Optional<Subscription> findByTicketNumber(Long ticketNumber);

    @Transactional
    void deleteByTicketNumber(Long ticketNumber);

    Long countByEventId(Long eventId);

    @Query(value = "select s.event_id from subscriptions s where s.username = :username", nativeQuery = true)
    List<Long> findEventsPurchasedByUser(@Param("username") String username);

}