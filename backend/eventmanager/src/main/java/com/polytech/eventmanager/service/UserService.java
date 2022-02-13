package com.polytech.eventmanager.service;

import com.polytech.eventmanager.model.EventSubscription;
import com.polytech.eventmanager.model.User;
import com.polytech.eventmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
        this.initUsers();
    }

    public void initUsers() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            User user1 = new User();
            user1.setUsername("user1");
            user1.setFirstname("john");
            user1.setLastname("doe");
            user1.setEmail("mail1@test.com");
            user1.setPassword("letmein");
            user1.setDateOfBirth(sdf.parse("12/01/1980"));

            User user2 = new User();
            user2.setUsername("user2");
            user2.setFirstname("allison");
            user2.setLastname("white");
            user2.setEmail("mail2@test.com");
            user2.setPassword("pass");
            user2.setDateOfBirth(sdf.parse("04/02/1983"));

            this.repository.save(user1);
            this.repository.save(user2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        return this.repository.findAll();
    }

    public User getUserByUsername(String username) {
        Optional<User> found = this.repository.findByUsername(username);
        return found.orElse(null);
    }

    public User createUser(User givenUser) {
        User found = getUserByUsername(givenUser.getUsername());
        if (found == null) {
            return this.repository.save(givenUser);
        }
        return null;
    }

    public boolean deleteUserByUsername(String username) {
        User found = getUserByUsername(username);
        if (found != null) {
            this.repository.deleteById(found.getId());
            return true;
        }
        return false;
    }

    public User updateUser(User givenUser) {
        User found = getUserByUsername(givenUser.getUsername());
        if (found != null) {
            givenUser.setId(found.getId());
            return this.repository.save(givenUser);
        }
        return null;
    }

}
