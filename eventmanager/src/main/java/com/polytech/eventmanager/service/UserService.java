package com.polytech.eventmanager.service;

import com.polytech.eventmanager.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public List<User> list = new ArrayList<>();
    public Integer id = 1;

    public UserService() {
        User user1 = new User();
        user1.setNickname("user1");
        user1.setEmailAddress("mail@test.com");
        user1.setId(this.id++);

        User user2 = new User();
        user2.setNickname("user2");
        user2.setEmailAddress("mail2@test.com");
        user2.setId(this.id++);

        this.list.add(user1);
        this.list.add(user2);
    }

    public List<User> getAllUsers() {
        return this.list;
    }

    public User getUserById(long id) {
        for (User user : this.list) {
            if (user.getId() == id) return user;
        }
        return null;
    }

    public User createUser(User givenUser) {
        if (givenUser.getNickname() != null && givenUser.getEmailAddress() != null) {
            givenUser.setId(this.id++);
            this.list.add(givenUser);
            return givenUser;
        }
        return null;
    }

    public boolean deleteUserById(long id) {
        for (User user : this.list) {
            if (user.getId() == id) {
                this.list.remove(user);
                return true;
            }
        }
        return false;
    }



}
