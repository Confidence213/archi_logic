package com.polytech.eventmanager.controller;

import com.polytech.eventmanager.dto.EventSubscriptionGetDto;
import com.polytech.eventmanager.dto.EventSubscriptionPostDto;
import com.polytech.eventmanager.mapper.EventSubscriptionMapper;
import com.polytech.eventmanager.model.EventSubscription;
import com.polytech.eventmanager.service.EventSubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user_event")
@RestController
@CrossOrigin(maxAge = 3600)
public class EventSubscriptionController {

    private final EventSubscriptionService eventSubscriptionService;

    public EventSubscriptionController(EventSubscriptionService eventSubscriptionService) {
        this.eventSubscriptionService = eventSubscriptionService;
    }

    @GetMapping("")
    public ResponseEntity<List<EventSubscriptionGetDto>> getAllEventSubscriptions() {
        List<EventSubscription> eventSubscriptions = eventSubscriptionService.getAllEventSubscriptions();
        List<EventSubscriptionGetDto> eventSubscriptionsDtos = EventSubscriptionMapper.toEventSubscriptionGetDtoList(eventSubscriptions);

        return ResponseEntity.ok(eventSubscriptionsDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventSubscriptionGetDto> getEventSubscriptionById(@PathVariable Long id) {
        EventSubscription eventSubscription = eventSubscriptionService.getEventSubscriptionById(id);
        if (eventSubscription == null) return ResponseEntity.notFound().build();

        EventSubscriptionGetDto dto = EventSubscriptionMapper.toEventSubscriptionGetDto(eventSubscription);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<EventSubscriptionGetDto> createEventSubscription(@RequestBody EventSubscriptionPostDto dto) {
        EventSubscription fromDto = EventSubscriptionMapper.toEventSubscription(dto);

        EventSubscription createdEventSubscription = eventSubscriptionService.createEventSubscription(fromDto);
        if (createdEventSubscription == null) return ResponseEntity.badRequest().build();

        EventSubscriptionGetDto createdEventSubscriptionDto = EventSubscriptionMapper.toEventSubscriptionGetDto(createdEventSubscription);
        return ResponseEntity.ok(createdEventSubscriptionDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EventSubscriptionGetDto> deleteEventSubscription(@PathVariable Long id) {
        boolean deletedEventSubscription = eventSubscriptionService.deleteEventSubscriptionById(id);
        if (!deletedEventSubscription) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EventSubscriptionGetDto> updateEventSubscription(@PathVariable Long id, @RequestBody EventSubscriptionPostDto dto) {
        EventSubscription fromDto = EventSubscriptionMapper.toEventSubscription(dto);
        fromDto.setId(id);

        EventSubscription updatedEventSubscription = eventSubscriptionService.updateEventSubscription(fromDto);
        if (updatedEventSubscription == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        EventSubscriptionGetDto updatedEventSubscriptionDto = EventSubscriptionMapper.toEventSubscriptionGetDto(updatedEventSubscription);
        return ResponseEntity.ok(updatedEventSubscriptionDto);
    }

}
