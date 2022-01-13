package com.polytech.eventmanager.service;

import com.polytech.eventmanager.model.User;
import com.polytech.eventmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

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
        user1.setEmail("mail@test.com");

        User user2 = new User();
        user2.setNickname("user2");
        user2.setEmail("mail2@test.com");

        this.repository.save(user1);
        this.repository.save(user2);
    }

    public List<User> getAllUsers() {
        return this.repository.findAll();
    }

    public User getUserById(Integer userId) {
        Optional<User> found = this.repository.findById(userId);
        if (found.isPresent()) return found.get();
        return null;
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
