package com.polytech.eventmanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class SubscriptionPostDto {

    @NotNull
    @JsonProperty("user_username")
    private String userUsername;

    @NotNull
    @JsonProperty("event_id")
    private Long eventId;

}