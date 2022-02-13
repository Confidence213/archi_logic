package com.polytech.eventmanager.mapper;

import com.polytech.eventmanager.dto.SubscriptionGetDto;
import com.polytech.eventmanager.dto.SubscriptionPostDto;
import com.polytech.eventmanager.model.Subscription;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionMapper {

    public static SubscriptionGetDto toSubscriptionGetDto(Subscription subscription) {
        return SubscriptionGetDto.builder()
                .id(subscription.getId())
                .userUsername(subscription.getUserUsername())
                .eventId(subscription.getEventId())
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

    public static Subscription toSubscription(SubscriptionGetDto dto) {
        return Subscription.builder()
                .id(dto.getId())
                .userUsername(dto.getUserUsername())
                .eventId(dto.getEventId())
                .dateOfOrder(dto.getDateOfOrder())
                .build();
    }

    public static List<Subscription> toSubscriptionListFromGet(List<SubscriptionGetDto> list) {
        List<Subscription> subscriptionList = new ArrayList<>();
        for (SubscriptionGetDto dto : list) {
            subscriptionList.add(toSubscription(dto));
        }
        return subscriptionList;
    }

    public static SubscriptionGetDto toSubscriptionPostDto(Subscription subscription) {
        return SubscriptionGetDto.builder()
                .userUsername(subscription.getUserUsername())
                .eventId(subscription.getEventId())
                .build();
    }

    public static List<SubscriptionGetDto> toSubscriptionPostDtoList(List<Subscription> list) {
        List<SubscriptionGetDto> dtoList = new ArrayList<>();
        for (Subscription subscription : list) {
            dtoList.add(toSubscriptionPostDto(subscription));
        }
        return dtoList;
    }

    public static Subscription toSubscription(SubscriptionPostDto dto) {
        return Subscription.builder()
                .userUsername(dto.getUserUsername())
                .eventId(dto.getEventId())
                .build();
    }

    public static List<Subscription> toSubscriptionListFromPost(List<SubscriptionPostDto> list) {
        List<Subscription> subscriptionList = new ArrayList<>();
        for (SubscriptionPostDto dto : list) {
            subscriptionList.add(toSubscription(dto));
        }
        return subscriptionList;
    }

}
