package com.polytech.eventmanager.mapper;

import com.polytech.eventmanager.dto.EventSubscriptionGetDto;
import com.polytech.eventmanager.dto.EventSubscriptionPostDto;
import com.polytech.eventmanager.model.EventSubscription;

import java.util.ArrayList;
import java.util.List;

public class EventSubscriptionMapper {

    public static EventSubscriptionGetDto toEventSubscriptionGetDto(EventSubscription eventSubscription) {
        return EventSubscriptionGetDto.builder()
                .id(eventSubscription.getId())
                .username(eventSubscription.getUsername())
                .eventId(eventSubscription.getEventId())
                .dateOfOrder(eventSubscription.getDateOfOrder())
                .build();
    }

    public static List<EventSubscriptionGetDto> toEventSubscriptionGetDtoList(List<EventSubscription> list) {
        List<EventSubscriptionGetDto> dtoList = new ArrayList<>();
        for (EventSubscription eventSubscription : list) {
            dtoList.add(toEventSubscriptionGetDto(eventSubscription));
        }
        return dtoList;
    }

    public static EventSubscription toEventSubscription(EventSubscriptionGetDto dto) {
        return EventSubscription.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .eventId(dto.getEventId())
                .dateOfOrder(dto.getDateOfOrder())
                .build();
    }

    public static List<EventSubscription> toEventSubscriptionListFromGet(List<EventSubscriptionGetDto> list) {
        List<EventSubscription> eventSubscriptionList = new ArrayList<>();
        for (EventSubscriptionGetDto dto : list) {
            eventSubscriptionList.add(toEventSubscription(dto));
        }
        return eventSubscriptionList;
    }

    public static EventSubscriptionGetDto toEventSubscriptionPostDto(EventSubscription eventSubscription) {
        return EventSubscriptionGetDto.builder()
                .username(eventSubscription.getUsername())
                .eventId(eventSubscription.getEventId())
                .build();
    }

    public static List<EventSubscriptionGetDto> toEventSubscriptionPostDtoList(List<EventSubscription> list) {
        List<EventSubscriptionGetDto> dtoList = new ArrayList<>();
        for (EventSubscription eventSubscription : list) {
            dtoList.add(toEventSubscriptionPostDto(eventSubscription));
        }
        return dtoList;
    }

    public static EventSubscription toEventSubscription(EventSubscriptionPostDto dto) {
        return EventSubscription.builder()
                .username(dto.getUsername())
                .eventId(dto.getEventId())
                .build();
    }

    public static List<EventSubscription> toEventSubscriptionListFromPost(List<EventSubscriptionPostDto> list) {
        List<EventSubscription> eventSubscriptionList = new ArrayList<>();
        for (EventSubscriptionPostDto dto : list) {
            eventSubscriptionList.add(toEventSubscription(dto));
        }
        return eventSubscriptionList;
    }

}
