package com.polytech.eventmanager.controller;

import com.polytech.eventmanager.dto.EventDto;
import com.polytech.eventmanager.mapper.EventMapper;
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
    public ResponseEntity<List<EventDto>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        List<EventDto> eventsDtos = EventMapper.toEventDTOList(events);

        return ResponseEntity.ok(eventsDtos);
    }

    // todo: add other methods
    @GetMapping("/{eventId}")
    public ResponseEntity<EventDto> getEventById(@PathVariable Integer eventId) {
        Event event = eventService.getEventById(eventId);

        if (event == null) {
            return ResponseEntity.notFound().build();
        }
        EventDto dto = EventMapper.toEventDTO(event);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<EventDto> createEvent(@RequestBody EventDto dto) {
        Event fromDto = EventMapper.toEvent(dto);
        Event createdEvent = eventService.createEvent(fromDto);
        if (createdEvent == null) {
            return ResponseEntity.badRequest().build();
        }
        EventDto createdEventDto = EventMapper.toEventDTO(createdEvent);
        return ResponseEntity.ok(createdEventDto);
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<Event> deleteUser(@PathVariable Integer eventId) {
        boolean deletedEvent = eventService.deleteEvent(eventId);
        if (!deletedEvent) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok().build();
    }

}
