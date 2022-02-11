package com.polytech.eventmanager.mapper;

import com.polytech.eventmanager.dto.EventDto;
import com.polytech.eventmanager.model.Event;

import java.util.*;

public class EventMapper {

    public static EventDto toEventDTO(Event event) {
        return EventDto.builder()
                .name(event.getName())
                .place(event.getPlace())
                .build();
    }

    public static List<EventDto> toEventDTOList(List<Event> list) {
        List<EventDto> dtoList = new ArrayList<>();
        for (Event event : list) {
            dtoList.add(toEventDTO(event));
        }
        return dtoList;
    }

    public static Event toEvent(EventDto dto) {
        return Event.builder()
                .name(dto.getName())
                .Place(dto.getPlace())
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
