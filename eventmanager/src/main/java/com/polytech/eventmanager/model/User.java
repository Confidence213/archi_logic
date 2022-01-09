package com.polytech.eventmanager.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {

    protected long id;

    protected String nickname;

    protected String firstname;

    protected String lastname;

    protected String password;

    protected String emailAddress;

    protected Date dateOfBirth;

}
