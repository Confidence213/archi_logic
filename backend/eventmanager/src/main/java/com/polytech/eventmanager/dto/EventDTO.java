package com.polytech.eventmanager.dto;

import lombok.*;

@Data
@Builder
public class EventDTO {
    private String name;
    private String place;
    private String MaxOfParticipant;
}