package com.polytech.eventmanager.controller;

import com.polytech.eventmanager.dto.UserGetDto;
import com.polytech.eventmanager.dto.UserPostDto;
import com.polytech.eventmanager.mapper.UserMapper;
import com.polytech.eventmanager.model.User;
import com.polytech.eventmanager.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
@CrossOrigin(maxAge = 3600)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<UserGetDto>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserGetDto> usersDtos = UserMapper.toUserGetDtoList(users);

        return ResponseEntity.ok(usersDtos);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserGetDto> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user == null) return ResponseEntity.notFound().build();

        UserGetDto dto = UserMapper.toUserGetDto(user);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<UserGetDto> createUser(@RequestBody UserPostDto dto) {
        User fromDto = UserMapper.toUser(dto);

        User createdUser = userService.createUser(fromDto);
        if (createdUser == null) return ResponseEntity.badRequest().build();

        UserGetDto createdUserDto = UserMapper.toUserGetDto(createdUser);
        return ResponseEntity.ok(createdUserDto);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<UserGetDto> deleteUser(@PathVariable String username) {
        boolean status = userService.deleteUserByUsername(username);
        if (!status) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{username}")
    public ResponseEntity<UserGetDto> updateUser(@PathVariable String username, @RequestBody UserPostDto dto) {
        User fromDto = UserMapper.toUser(dto);
        fromDto.setUsername(username);

        User updatedUser = userService.updateUser(fromDto);
        if (updatedUser == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        UserGetDto updatedUserDto = UserMapper.toUserGetDto(updatedUser);
        return ResponseEntity.ok(updatedUserDto);
    }

}
