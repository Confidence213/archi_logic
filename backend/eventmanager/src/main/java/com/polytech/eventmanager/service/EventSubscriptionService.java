package com.polytech.eventmanager.service;

import com.polytech.eventmanager.model.EventSubscription;
import com.polytech.eventmanager.repository.EventSubscriptionRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EventSubscriptionService {

    private final EventSubscriptionRepository repository;

    public EventSubscriptionService(EventSubscriptionRepository repository) {
        this.repository = repository;
    }

    public List<EventSubscription> getAllEventSubscriptions() {
        return this.repository.findAll();
    }

    public EventSubscription getEventSubscriptionById(Long id) {
        Optional<EventSubscription> found = this.repository.findById(id);
        return found.orElse(null);
    }

    public EventSubscription createEventSubscription(EventSubscription givenEventSubscription) {
        givenEventSubscription.setDateOfOrder(new Date());
        if (givenEventSubscription.getUsername() != null && givenEventSubscription.getEventId() != 0) {
            return this.repository.save(givenEventSubscription);
        }
        return null;
    }

    public boolean deleteEventSubscriptionById(Long id) {
        EventSubscription found = getEventSubscriptionById(id);
        if (found != null) {
            this.repository.deleteById(found.getId());
            return true;
        }
        return false;
    }

    public EventSubscription updateEventSubscription(EventSubscription givenEventSubscription) {
        EventSubscription found = getEventSubscriptionById(givenEventSubscription.getId());
        if (found != null) {
            return this.repository.save(givenEventSubscription);
        }
        return null;
    }

}

