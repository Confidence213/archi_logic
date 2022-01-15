package com.polytech.eventmanager.service;

import com.polytech.eventmanager.model.User;
import com.polytech.eventmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        User user1 = new User();
        user1.setNickname("user1");
        user1.setFirstname("john");
        user1.setLastname("doe");
        user1.setEmail("mail1@test.com");
        user1.setPassword("letmein");
        user1.setDateOfBirth(new Date());

        User user2 = new User();
        user1.setNickname("user2");
        user1.setFirstname("allison");
        user1.setLastname("white");
        user1.setEmail("mail2@test.com");
        user1.setPassword("pass");
        user1.setDateOfBirth(new Date());

        this.repository.save(user1);
        this.repository.save(user2);
    }

    public List<User> getAllUsers() {
        return this.repository.findAll();
    }

    public User getUserById(Integer userId) {
        Optional<User> found = this.repository.findById(userId);
        return found.orElse(null);
    }

    public User createUser(User givenUser) {
        if (givenUser.getNickname() != null && givenUser.getEmail() != null) {
            return this.repository.save(givenUser);
        }
        return null;
    }

    public boolean deleteUserById(Integer userId) {
        User found = getUserById(userId);
        if (found != null) {
            this.repository.deleteById(found.getId());
            return true;
        }
        return false;
    }

}
