package com.polytech.eventmanager.dto;

import lombok.*;

import java.util.Date;

@Data
@Builder
public class UserDTO {
    private String nickname;
    private String firstname;
    private String lastname;
    private String email;
    protected Date dateOfBirth;
}