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
@CrossOrigin(maxAge = 3600)
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("")
    public ResponseEntity<List<EventDto>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        List<EventDto> eventsDtos = EventMapper.toEventDtoList(events);

        return ResponseEntity.ok(eventsDtos);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventDto> getEventById(@PathVariable Integer eventId) {
        Event event = eventService.getEventById(eventId);
        if (event == null) return ResponseEntity.notFound().build();

        EventDto dto = EventMapper.toEventDto(event);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<EventDto> createEvent(@RequestBody EventDto dto) {
        Event fromDto = EventMapper.toEvent(dto);

        Event createdEvent = eventService.createEvent(fromDto);
        if (createdEvent == null) return ResponseEntity.badRequest().build();

        EventDto createdEventDto = EventMapper.toEventDto(createdEvent);
        return ResponseEntity.ok(createdEventDto);
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<Event> deleteUser(@PathVariable Integer eventId) {
        boolean deletedEvent = eventService.deleteEventById(eventId);
        if (!deletedEvent) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{eventId}")
    public ResponseEntity<EventDto> updateEvent(@PathVariable Integer eventId, @RequestBody EventDto dto) {
        Event fromDto = EventMapper.toEvent(dto);
        fromDto.setId(eventId);

        Event updatedEvent = eventService.updateEvent(fromDto);
        if (updatedEvent == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        EventDto updatedEventDto = EventMapper.toEventDto(updatedEvent);
        return ResponseEntity.ok(updatedEventDto);
    }

}
