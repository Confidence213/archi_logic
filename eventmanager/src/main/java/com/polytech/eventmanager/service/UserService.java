package com.polytech.eventmanager.service;

import com.polytech.eventmanager.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public List<User> getAllUsers() {
        User user1 = new User();
        user1.setNickname("user1");
        user1.setEmailAddress("mail@test.com");

        User user2 = new User();
        user2.setNickname("user2");
        user2.setEmailAddress("mail2@test.com");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);

        return list;
    }

}
