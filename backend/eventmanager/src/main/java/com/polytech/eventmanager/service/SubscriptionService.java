package com.polytech.eventmanager.service;

import com.polytech.eventmanager.model.Subscription;
import com.polytech.eventmanager.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    private final SubscriptionRepository repository;

    public SubscriptionService(SubscriptionRepository repository) {
        this.repository = repository;
    }

    public List<Subscription> getAllSubscriptions() {
        return this.repository.findAll();
    }

    public Subscription getSubscriptionByTicketNumber(Long ticketNumber) {
        Optional<Subscription> found = this.repository.findByTicketNumber(ticketNumber);
        return found.orElse(null);
    }

    public Subscription createSubscription(Subscription givenSubscription) {
        Optional<Subscription> found = this.repository.findById(
                givenSubscription.getId().getUserId(),
                givenSubscription.getId().getEventId());
        if (found.isEmpty()) {
            return this.repository.save(givenSubscription);
        }
        return null;
    }

    // todo: solve error with repository sql request
    public boolean deleteSubscriptionByTicketNumber(Long ticketNumber) {
        Subscription found = getSubscriptionByTicketNumber(ticketNumber);
        if (found != null) {
            this.repository.deleteByTicketNumber(ticketNumber);
            return true;
        }
        return false;
    }

    // todo: solve error of saving duplicate
    public Subscription updateSubscription(Subscription givenSubscription) {
        Subscription found = getSubscriptionByTicketNumber(givenSubscription.getTicketNumber());
        if (found != null) {
            Optional<Subscription> found2 = this.repository.findById(
                    givenSubscription.getId().getUserId(),
                    givenSubscription.getId().getEventId());
            if (found2.isEmpty()) {
                return this.repository.save(givenSubscription);
            }
            return null;
        }
        return null;
    }

}

