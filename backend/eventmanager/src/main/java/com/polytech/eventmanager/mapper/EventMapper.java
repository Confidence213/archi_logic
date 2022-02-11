package com.polytech.eventmanager.mapper;

import com.polytech.eventmanager.dto.EventDTO;
import com.polytech.eventmanager.model.Event;

import java.util.*;

public class EventMapper {

    public static EventDTO toEventDTO(Event event) {
        return EventDTO.builder()
                .name(event.getName())
                .place(event.getPlace())
                .build();
    }

    public static List<EventDTO> toEventDTOList(List<Event> list) {
        List<EventDTO> dtoList = new ArrayList<>();
        for (Event event : list) {
            dtoList.add(toEventDTO(event));
        }
        return dtoList;
    }

    public static Event toEvent(EventDTO dto) {
        return Event.builder()
                .name(dto.getName())
                .Place(dto.getPlace())
                .build();
    }

    public static List<Event> toEventList(List<EventDTO> list) {
        List<Event> eventList = new ArrayList<>();
        for (EventDTO dto : list) {
            eventList.add(toEvent(dto));
        }
        return eventList;
    }

}
