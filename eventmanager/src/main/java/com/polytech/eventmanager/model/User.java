package com.polytech.eventmanager.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    protected long id;

    protected String nickname;

    protected String firstname;

    protected String lastname;

    protected String password;

    protected String emailAddress;

    protected Date dateOfBirth;

}
