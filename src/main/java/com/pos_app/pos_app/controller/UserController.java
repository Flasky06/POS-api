package com.pos_app.pos_app.controller;

import com.pos_app.pos_app.domain.dto.UserRequestDto;
import com.pos_app.pos_app.domain.dto.UserDto;
import com.pos_app.pos_app.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * Create a new user
     */
    @PostMapping
    public ResponseEntity<UserDto> registerUser(@RequestBody UserRequestDto userRequestDto) {
        UserDto createdUser = userService.createUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    /**
     * Get list of all users
     */
    @GetMapping
    public ResponseEntity<List<UserDto>> listUsers() {
        List<UserDto> users = userService.listUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * Get a single user by ID
     */
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable UUID userId) {
        UserDto user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    /**
     * Update a user by ID
     */
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserRequestDto userRequestDto,
                                              @PathVariable UUID userId) {
        UserDto updatedUser = userService.updateUser(userRequestDto, userId);
        return ResponseEntity.ok(updatedUser);
    }

    /**
     * Delete a user by ID
     */
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
