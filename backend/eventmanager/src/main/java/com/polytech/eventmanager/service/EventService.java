package com.polytech.eventmanager.service;

import com.polytech.eventmanager.model.Event;
import com.polytech.eventmanager.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
        this.initEvents();
    }

    public void initEvents() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Event event1 = new Event();
            event1.setTitle("event1");
            event1.setPlace("Lille");
            event1.setDate(sdf.parse("14/03/2022"));
            event1.setPrice(100);

            Event event2 = new Event();
            event2.setTitle("event2");
            event2.setPlace("Miami");
            event2.setDate(sdf.parse("18/11/2022"));
            event2.setPrice(230);

            this.repository.save(event1);
            this.repository.save(event2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<Event> getAllEvents() {
        return this.repository.findAll();
    }

    public Event getEventById(Long id) {
        Optional<Event> found = this.repository.findById(id);
        return found.orElse(null);
    }

    public Event createEvent(Event givenEvent) {
        if (givenEvent.getTitle() != null && givenEvent.getPlace() != null && givenEvent.getDate() != null && givenEvent.getPrice() != null) {
            return this.repository.save(givenEvent);
        }
        return null;
    }

    public boolean deleteEventById(Long id) {
        Event found = getEventById(id);
        if (found != null) {
            this.repository.deleteById(found.getId());
            return true;
        }
        return false;
    }

    public Event updateEvent(Event givenEvent) {
        Event found = getEventById(givenEvent.getId());
        if (found != null) {
            return this.repository.save(givenEvent);
        }
        return null;
    }

}
