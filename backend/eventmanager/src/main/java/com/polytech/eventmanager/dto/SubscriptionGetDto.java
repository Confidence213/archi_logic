package com.polytech.eventmanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
public class SubscriptionGetDto {

    @NotNull
    @JsonProperty("username")
    private String username;

    @NotNull
    @JsonProperty("eventId")
    private Long eventId;

    @NotNull
    @JsonProperty("ticketNumber")
    private Long ticketNumber;

    @NotNull
    @JsonProperty("dateOfOrder")
    protected Date dateOfOrder;

}