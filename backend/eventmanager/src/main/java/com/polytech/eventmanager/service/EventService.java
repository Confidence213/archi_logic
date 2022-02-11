package com.polytech.eventmanager.service;

import com.polytech.eventmanager.model.Event;
import com.polytech.eventmanager.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
        this.initUsers();
    }

    public void initUsers() {
        Event event1 = new Event();
        event1.setTitle("event1");
        event1.setPlace("Lille");
        event1.setPrice(100);

        Event event2 = new Event();
        event2.setTitle("event2");
        event2.setPlace("Miami");
        event2.setPrice(230);

        this.repository.save(event1);
        this.repository.save(event2);
    }

    public List<Event> getAllEvents() {
        return this.repository.findAll();
    }

    public Event getEventById(Integer id) {
        Optional<Event> found = this.repository.findById(id);
        return found.orElse(null);
    }

    public Event createEvent(Event givenEvent) {
        Event found = getEventById(givenEvent.getId());
        if (found == null) {
            return this.repository.save(givenEvent);
        }
        return null;
    }

    public boolean deleteEventById(Integer eventId) {
        Event found = getEventById(eventId);
        if (found != null) {
            this.repository.deleteById(found.getId());
            return true;
        }
        return false;
    }

    public Event updateEvent(Event givenEvent) {
        Event found = getEventById(givenEvent.getId());
        if (found != null) {
            givenEvent.setId(found.getId());
            return this.repository.save(givenEvent);
        }
        return null;
    }

}