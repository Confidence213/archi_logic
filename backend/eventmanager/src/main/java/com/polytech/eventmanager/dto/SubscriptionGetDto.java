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
    @JsonProperty("ticket_number")
    private Long id;

    @NotNull
    @JsonProperty("user_username")
    private String userUsername;

    @NotNull
    @JsonProperty("event_id")
    private Long eventId;

    @NotNull
    @JsonProperty("date_of_order")
    protected Date dateOfOrder;

}