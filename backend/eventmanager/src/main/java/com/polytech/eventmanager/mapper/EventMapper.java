package com.polytech.eventmanager.mapper;

import com.polytech.eventmanager.dto.EventGetDto;
import com.polytech.eventmanager.dto.EventPostDto;
import com.polytech.eventmanager.model.Event;

import java.util.*;

public class EventMapper {

    public static EventGetDto toEventGetDto(Event event) {
        return EventGetDto.builder()
                .id(event.getId())
                .title(event.getTitle())
                .description(event.getDescription())
                .place(event.getPlace())
                .date(event.getDate())
                .price(event.getPrice())
                .build();
    }

    public static List<EventGetDto> toEventGetDtoList(List<Event> list) {
        List<EventGetDto> dtoList = new ArrayList<>();
        for (Event event : list) {
            dtoList.add(toEventGetDto(event));
        }
        return dtoList;
    }

    public static Event toEvent(EventGetDto dto) {
        return Event.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .place(dto.getPlace())
                .date(dto.getDate())
                .price(dto.getPrice())
                .build();
    }

    public static List<Event> toEventListFromGet(List<EventGetDto> list) {
        List<Event> eventList = new ArrayList<>();
        for (EventGetDto dto : list) {
            eventList.add(toEvent(dto));
        }
        return eventList;
    }

    public static EventPostDto toEventPostDto(Event event) {
        return EventPostDto.builder()
                .title(event.getTitle())
                .description(event.getDescription())
                .place(event.getPlace())
                .date(event.getDate())
                .price(event.getPrice())
                .build();
    }

    public static List<EventPostDto> toEventPostDtoList(List<Event> list) {
        List<EventPostDto> dtoList = new ArrayList<>();
        for (Event event : list) {
            dtoList.add(toEventPostDto(event));
        }
        return dtoList;
    }

    public static Event toEvent(EventPostDto dto) {
        return Event.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .place(dto.getPlace())
                .date(dto.getDate())
                .price(dto.getPrice())
                .build();
    }

    public static List<Event> toEventListFromPost(List<EventPostDto> list) {
        List<Event> eventList = new ArrayList<>();
        for (EventPostDto dto : list) {
            eventList.add(toEvent(dto));
        }
        return eventList;
    }

}
