package com.polytech.eventmanager.mapper;

import com.polytech.eventmanager.dto.SubscriptionGetDto;
import com.polytech.eventmanager.model.Event;
import com.polytech.eventmanager.model.Subscription;
import com.polytech.eventmanager.model.SubscriptionId;
import com.polytech.eventmanager.model.User;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionMapper {

    public static SubscriptionGetDto toSubscriptionGetDto(Subscription subscription) {
        return SubscriptionGetDto.builder()
                .username(subscription.getUser().getUsername())
                .eventId(subscription.getEvent().getId())
                .ticketNumber(subscription.getTicketNumber())
                .dateOfOrder(subscription.getDateOfOrder())
                .build();
    }

    public static List<SubscriptionGetDto> toSubscriptionGetDtoList(List<Subscription> list) {
        List<SubscriptionGetDto> dtoList = new ArrayList<>();
        for (Subscription subscription : list) {
            dtoList.add(toSubscriptionGetDto(subscription));
        }
        return dtoList;
    }

    public static Subscription toSubscription(User user, Event event) {
        return Subscription.builder()
                .id(new SubscriptionId(user.getId(), event.getId()))
                .user(user)
                .event(event)
                .build();
    }

}
