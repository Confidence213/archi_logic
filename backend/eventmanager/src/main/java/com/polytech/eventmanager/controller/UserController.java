package com.polytech.eventmanager.controller;

import com.polytech.eventmanager.dto.UserDTO;
import com.polytech.eventmanager.mapper.UserMapper;
import com.polytech.eventmanager.model.User;
import com.polytech.eventmanager.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserDTO> usersDtos = UserMapper.toUserDTOList(users);

        return ResponseEntity.ok(usersDtos);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userId) {
        User user = userService.getUserById(userId);
        if (user == null) return ResponseEntity.notFound().build();

        UserDTO dto = UserMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO dto) {
        User fromDto = UserMapper.toUser(dto);
        User createdUser = userService.createUser(fromDto);
        if (createdUser == null) return ResponseEntity.badRequest().build();

        UserDTO createdUserDto = UserMapper.toUserDTO(createdUser);
        return ResponseEntity.ok(createdUserDto);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Integer userId) {
        boolean status = userService.deleteUserById(userId);
        if (!status) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok().build();
    }

}
