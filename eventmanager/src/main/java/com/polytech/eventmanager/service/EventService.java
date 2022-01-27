package com.polytech.eventmanager.service;

import com.polytech.eventmanager.model.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    public List<Event> list = new ArrayList<>();
    public Integer id = 1;

    public List<Event> getAllEvent() {
        Event event1 = new Event();
        event1.setName("event1");
        event1.setDescription("Le plus grand des festoch");
        event1.setPlace("Lille");
        event1.setMaxOfParticipant(3500);
        event1.setPrice(34.50);

        List<Event> list = new ArrayList<>();
        list.add(event1);

        return list;
    }


    public Event getEventById(Integer id) {
        List<Event> events = this.getAllEvent();
        for (Event event : events) {
            if (event.getId() == id) {
                return event;
            }
        }
        return null;
    }

    public Event createEvent(Event givenEvent) {
        if (givenEvent.getName() != null && givenEvent.getDescription() != null) {
            givenEvent.setId(this.id++);
            this.list.add(givenEvent);
            return givenEvent;
        }
        return null;
    }





}
