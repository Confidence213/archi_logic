package com.polytech.eventmanager.mapper;

import com.polytech.eventmanager.dto.EventDto;
import com.polytech.eventmanager.model.Event;

import java.util.*;

public class EventMapper {

    public static EventDto toEventDto(Event event) {
        return EventDto.builder()
                .title(event.getTitle())
                .description(event.getDescription())
                .place(event.getPlace())
                .date(event.getDate())
                .price(event.getPrice())
                .build();
    }

    public static List<EventDto> toEventDtoList(List<Event> list) {
        List<EventDto> dtoList = new ArrayList<>();
        for (Event event : list) {
            dtoList.add(toEventDto(event));
        }
        return dtoList;
    }

    public static Event toEvent(EventDto dto) {
        return Event.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .place(dto.getPlace())
                .date(dto.getDate())
                .price(dto.getPrice())
                .build();
    }

    public static List<Event> toEventList(List<EventDto> list) {
        List<Event> eventList = new ArrayList<>();
        for (EventDto dto : list) {
            eventList.add(toEvent(dto));
        }
        return eventList;
    }

}
