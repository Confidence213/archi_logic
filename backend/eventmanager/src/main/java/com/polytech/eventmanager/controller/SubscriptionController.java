package com.polytech.eventmanager.controller;

import com.polytech.eventmanager.dto.SubscriptionGetDto;
import com.polytech.eventmanager.dto.SubscriptionPostDto;
import com.polytech.eventmanager.mapper.SubscriptionMapper;
import com.polytech.eventmanager.model.Event;
import com.polytech.eventmanager.model.Subscription;
import com.polytech.eventmanager.model.User;
import com.polytech.eventmanager.service.EventService;
import com.polytech.eventmanager.service.SubscriptionService;
import com.polytech.eventmanager.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/subscription")
@RestController
@CrossOrigin(maxAge = 3600)
public class SubscriptionController {

    private final SubscriptionService subscriptionService;
    private final UserService userService;
    private final EventService eventService;

    public SubscriptionController(SubscriptionService subscriptionService, UserService userService, EventService eventService) {
        this.subscriptionService = subscriptionService;
        this.userService = userService;
        this.eventService = eventService;
    }

    @GetMapping("")
    public ResponseEntity<List<SubscriptionGetDto>> getAllSubscriptions() {
        List<Subscription> subscriptions = subscriptionService.getAllEventSubscriptions();
        List<SubscriptionGetDto> dtos = SubscriptionMapper.toSubscriptionGetDtoList(subscriptions);

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionGetDto> getSubscriptionById(@PathVariable Long id) {
        Subscription subscription = subscriptionService.getEventSubscriptionById(id);
        if (subscription == null) return ResponseEntity.notFound().build();

        SubscriptionGetDto dto = SubscriptionMapper.toSubscriptionGetDto(subscription);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<SubscriptionGetDto> createSubscription(@RequestBody SubscriptionPostDto dto) {
        Subscription fromDto = SubscriptionMapper.toSubscription(dto);

        User user = userService.getUserByUsername(fromDto.getUserUsername());
        Event event = eventService.getEventById(fromDto.getEventId());
        if (user == null || event == null) return ResponseEntity.notFound().build();

        Subscription createdSubscription = subscriptionService.createEventSubscription(fromDto);
        if (createdSubscription == null) return ResponseEntity.badRequest().build();

        SubscriptionGetDto createdEventSubscriptionDto = SubscriptionMapper.toSubscriptionGetDto(createdSubscription);
        return ResponseEntity.ok(createdEventSubscriptionDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SubscriptionGetDto> deleteSubscription(@PathVariable Long id) {
        boolean deletedEventSubscription = subscriptionService.deleteEventSubscriptionById(id);
        if (!deletedEventSubscription) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SubscriptionGetDto> updateSubscription(@PathVariable Long id, @RequestBody SubscriptionPostDto dto) {
        Subscription fromDto = SubscriptionMapper.toSubscription(dto);
        fromDto.setId(id);

        User user = userService.getUserByUsername(fromDto.getUserUsername());
        Event event = eventService.getEventById(fromDto.getEventId());
        if (user == null || event == null) return ResponseEntity.notFound().build();

        Subscription updatedSubscription = subscriptionService.updateEventSubscription(fromDto);
        if (updatedSubscription == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        SubscriptionGetDto updatedEventSubscriptionDto = SubscriptionMapper.toSubscriptionGetDto(updatedSubscription);
        return ResponseEntity.ok(updatedEventSubscriptionDto);
    }

}
