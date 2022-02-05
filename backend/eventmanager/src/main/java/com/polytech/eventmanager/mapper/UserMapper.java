package com.polytech.eventmanager.mapper;

import com.polytech.eventmanager.dto.UserGetDto;
import com.polytech.eventmanager.dto.UserPostDto;
import com.polytech.eventmanager.model.User;

import java.util.*;

public class UserMapper {

    public static UserGetDto toUserGetDto(User user) {
        return UserGetDto.builder()
                .username(user.getUsername())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .dateOfBirth(user.getDateOfBirth())
                .email(user.getEmail())
                .build();
    }

    public static List<UserGetDto> toUserGetDtoList(List<User> list) {
        List<UserGetDto> dtoList = new ArrayList<>();
        for (User user : list) {
            dtoList.add(toUserGetDto(user));
        }
        return dtoList;
    }

    public static User toUser(UserGetDto dto) {
        return User.builder()
                .username(dto.getUsername())
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .dateOfBirth(dto.getDateOfBirth())
                .email(dto.getEmail())
                .build();
    }

    public static List<User> toUserListFromGet(List<UserGetDto> list) {
        List<User> userList = new ArrayList<>();
        for (UserGetDto dto : list) {
            userList.add(toUser(dto));
        }
        return userList;
    }

    public static UserPostDto toUserPostDto(User user) {
        return UserPostDto.builder()
                .username(user.getUsername())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .dateOfBirth(user.getDateOfBirth())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public static List<UserPostDto> toUserPostDtoList(List<User> list) {
        List<UserPostDto> dtoList = new ArrayList<>();
        for (User user : list) {
            dtoList.add(toUserPostDto(user));
        }
        return dtoList;
    }

    public static User toUser(UserPostDto dto) {
        return User.builder()
                .username(dto.getUsername())
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .dateOfBirth(dto.getDateOfBirth())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }

    public static List<User> toUserListFromPost(List<UserPostDto> list) {
        List<User> userList = new ArrayList<>();
        for (UserPostDto dto : list) {
            userList.add(toUser(dto));
        }
        return userList;
    }

}