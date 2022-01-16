package com.polytech.eventmanager.model;

import lombok.*;
import javax.persistence.*;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private Integer id;

    @Column(name = "nickname", nullable = false, length = 45)
    private String nickname;

    @Column(name = "firstname", nullable = false, length = 45)
    private String firstname;

    @Column(name = "lastname", nullable = false, length = 45)
    private String lastname;

    @Column(name = "email_address", length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 20)
    protected String password;

    @Column(name = "date_of_birth", nullable = false)
    protected Date dateOfBirth;
}
