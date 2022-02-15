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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/subscriptions")
@RestController
@CrossOrigin(maxAge = 3600)
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private UserService userService;
    @Autowired
    private EventService eventService;

    @GetMapping("")
    public ResponseEntity<List<SubscriptionGetDto>> getAllSubscriptions() {
        List<Subscription> subscriptions = subscriptionService.getAllSubscriptions();
        List<SubscriptionGetDto> dtos = SubscriptionMapper.toSubscriptionGetDtoList(subscriptions);

        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{ticketNumber}")
    public ResponseEntity<SubscriptionGetDto> getSubscriptionByTicketNumber(@PathVariable Long ticketNumber) {
        Subscription subscription = subscriptionService.getSubscriptionByTicketNumber(ticketNumber);
        if (subscription == null) return ResponseEntity.notFound().build();

        SubscriptionGetDto dto = SubscriptionMapper.toSubscriptionGetDto(subscription);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{eventId}/count")
    public ResponseEntity<Long> getEventParticipantNumber(@PathVariable Long eventId) {
        if (eventService.getEventById(eventId) == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(subscriptionService.getEventParticipantNumber(eventId));
    }

    @PostMapping("")
    public ResponseEntity<SubscriptionGetDto> createSubscription(@RequestBody SubscriptionPostDto dto) {
        User foundUser = userService.getUserByUsername(dto.getUsername());
        Event foundEvent = eventService.getEventById(dto.getEventId());
        if (foundUser == null || foundEvent == null) return ResponseEntity.notFound().build();

        Subscription fromDto = SubscriptionMapper.toSubscription(foundUser, foundEvent);
        fromDto.setDateOfOrder(new Date());

        Subscription createdSubscription = subscriptionService.createSubscription(fromDto);
        if (createdSubscription == null) return ResponseEntity.badRequest().build();

        SubscriptionGetDto createdEventSubscriptionDto = SubscriptionMapper.toSubscriptionGetDto(createdSubscription);
        return ResponseEntity.ok(createdEventSubscriptionDto);
    }

    @DeleteMapping("/{ticketNumber}")
    public ResponseEntity<SubscriptionGetDto> deleteSubscription(@PathVariable Long ticketNumber) {
        boolean deletedEventSubscription = subscriptionService.deleteSubscriptionByTicketNumber(ticketNumber);
        if (!deletedEventSubscription) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().build();
    }

    /*
    @PatchMapping("/{ticketNumber}")
    public ResponseEntity<SubscriptionGetDto> updateSubscription(
            @PathVariable Long ticketNumber,
            @RequestBody SubscriptionPostDto dto) {
        User foundUser = userService.getUserByUsername(dto.getUsername());
        Event foundEvent = eventService.getEventById(dto.getEventId());
        if (foundUser == null || foundEvent == null) return ResponseEntity.notFound().build();

        Subscription fromDto = SubscriptionMapper.toSubscription(foundUser, foundEvent);
        fromDto.setTicketNumber(ticketNumber);
        fromDto.setDateOfOrder(new Date());

        Subscription updatedSubscription = subscriptionService.updateSubscription(fromDto);
        if (updatedSubscription == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        SubscriptionGetDto updatedEventSubscriptionDto = SubscriptionMapper.toSubscriptionGetDto(updatedSubscription);
        return ResponseEntity.ok(updatedEventSubscriptionDto);
    }
    */

}
