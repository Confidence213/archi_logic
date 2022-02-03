package com.polytech.eventmanager.service;

import com.polytech.eventmanager.model.Event;
import com.polytech.eventmanager.repository.EventRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    public List<Event> list = new ArrayList<>();
    public Integer id = 1;

    public Event getEventById(Integer id) {

        Optional<Event> found = this.repository.findById(id);

        if (found.isPresent()) {
            return found.get();
        }
        return null;
    }

    public boolean deleteEvent(Integer eventId) {
        Event found = getEventById(eventId);
        if (found != null) {
            this.repository.deleteById(found.getId());
            return true;
        }
        return false;
    }

    public Event createEvent(Event givenEvent) {
        if (givenEvent.getName() != null && givenEvent.getDescription() != null) {
            return this.repository.save(givenEvent);
        }
        return null;
    }

    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
        this.initUsers();
    }

    public void initUsers() {
        Event event1 = new Event();
        event1.setName("event1");
        event1.setPlace("Lille");
        //event1.setPrice("4,1")";

        Event event2 = new Event();
        event2.setName("event2");
        event2.setPlace("Miami");

        this.repository.save(event1);
        this.repository.save(event2);
    }

    public List<Event> getAllEvents() {
        return this.repository.findAll();
    }

}
