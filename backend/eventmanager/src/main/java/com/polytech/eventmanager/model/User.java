package com.polytech.eventmanager.model;

import lombok.*;
import javax.persistence.*;

import java.util.Date;
import java.util.Set;

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
    private Long id;

    @Column(name = "username", nullable = false, unique = true, length = 45)
    private String username;

    @Column(name = "firstname", length = 45)
    private String firstname;

    @Column(name = "lastname", length = 45)
    private String lastname;

    @Column(name = "date_of_birth")
    protected Date dateOfBirth;

    @Column(name = "email_address", length = 100)
    private String email;

    @Column(name = "password", length = 50)
    protected String password;

    @OneToMany(mappedBy = "user")
    private Set<Subscription> subscriptions;

}
