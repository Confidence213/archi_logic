package com.polytech.eventmanager.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
public class UserPostDto {

    @NotNull
    @JsonProperty("username")
    private String username;

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("dateOfBirth")
    private Date dateOfBirth;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

}