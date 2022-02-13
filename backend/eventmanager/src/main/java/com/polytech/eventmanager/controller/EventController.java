package com.polytech.eventmanager.controller;

import com.polytech.eventmanager.dto.EventGetDto;
import com.polytech.eventmanager.dto.EventPostDto;
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
    public ResponseEntity<List<EventGetDto>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        List<EventGetDto> dtos = EventMapper.toEventGetDtoList(events);

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventGetDto> getEventById(@PathVariable Long eventId) {
        Event event = eventService.getEventById(eventId);
        if (event == null) return ResponseEntity.notFound().build();

        EventGetDto dto = EventMapper.toEventGetDto(event);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<EventGetDto> createEvent(@RequestBody EventPostDto dto) {
        Event fromDto = EventMapper.toEvent(dto);

        Event createdEvent = eventService.createEvent(fromDto);
        if (createdEvent == null) return ResponseEntity.badRequest().build();

        EventGetDto createdEventDto = EventMapper.toEventGetDto(createdEvent);
        return ResponseEntity.ok(createdEventDto);
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<EventGetDto> deleteEvent(@PathVariable Long eventId) {
        boolean deletedEvent = eventService.deleteEventById(eventId);
        if (!deletedEvent) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{eventId}")
    public ResponseEntity<EventGetDto> updateEvent(@PathVariable Long eventId, @RequestBody EventPostDto dto) {
        Event fromDto = EventMapper.toEvent(dto);
        fromDto.setId(eventId);

        Event updatedEvent = eventService.updateEvent(fromDto);
        if (updatedEvent == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        EventGetDto updatedEventDto = EventMapper.toEventGetDto(updatedEvent);
        return ResponseEntity.ok(updatedEventDto);
    }

}
