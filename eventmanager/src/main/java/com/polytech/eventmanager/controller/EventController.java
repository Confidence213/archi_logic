package com.polytech.eventmanager.controller;

import com.polytech.eventmanager.model.Event;
import com.polytech.eventmanager.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/events")
@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("")
    public ResponseEntity<List<Event>> getAllEvent() {
        return ResponseEntity.ok(eventService.getAllEvent());
    }

    // todo: add other methods
    @GetMapping("/{eventId}")
    public ResponseEntity<Event> getEventById(@PathVariable Integer eventId) {

        Event event = eventService.getEventById(eventId);

        if (event == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(event);
    }

    @PostMapping("")
    public ResponseEntity<Event> createUser(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        if (createdEvent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(event);
    }
}
