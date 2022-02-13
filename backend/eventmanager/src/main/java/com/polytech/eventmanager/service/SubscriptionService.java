package com.polytech.eventmanager.service;

import com.polytech.eventmanager.model.Subscription;
import com.polytech.eventmanager.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    private final SubscriptionRepository repository;

    public SubscriptionService(SubscriptionRepository repository) {
        this.repository = repository;
    }

    public List<Subscription> getAllEventSubscriptions() {
        return this.repository.findAll();
    }

    public Subscription getEventSubscriptionById(Long id) {
        Optional<Subscription> found = this.repository.findById(id);
        return found.orElse(null);
    }

    public Subscription createEventSubscription(Subscription givenSubscription) {
        givenSubscription.setDateOfOrder(new Date());
        if (givenSubscription.getUsername() != null && givenSubscription.getEventId() != 0) {
            return this.repository.save(givenSubscription);
        }
        return null;
    }

    public boolean deleteEventSubscriptionById(Long id) {
        Subscription found = getEventSubscriptionById(id);
        if (found != null) {
            this.repository.deleteById(found.getId());
            return true;
        }
        return false;
    }

    public Subscription updateEventSubscription(Subscription givenSubscription) {
        Subscription found = getEventSubscriptionById(givenSubscription.getId());
        if (found != null && givenSubscription.getUsername() != null && givenSubscription.getEventId() != 0) {
            givenSubscription.setDateOfOrder(found.getDateOfOrder());
            return this.repository.save(givenSubscription);
        }
        return null;
    }

}

