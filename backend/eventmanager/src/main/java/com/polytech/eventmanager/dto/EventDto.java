package com.polytech.eventmanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
public class EventDto {

    @NotNull
    @JsonProperty("id")
    private Integer id;

    @NotNull
    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @NotNull
    @JsonProperty("place")
    private String place;

    @JsonProperty("date")
    protected Date date;

    @NotNull
    @JsonProperty("price")
    private Integer price;

}