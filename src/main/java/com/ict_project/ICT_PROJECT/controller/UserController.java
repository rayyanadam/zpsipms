package com.ict_project.ICT_PROJECT.controller;

import com.ict_project.ICT_PROJECT.dto.UserRequest;
import com.ict_project.ICT_PROJECT.dto.UserResponse;
import com.ict_project.ICT_PROJECT.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private final UserServices userServices;
    private final ModelMapper modelMapper;

    @PostMapping("/add")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        UserResponse createdUserResponse = userServices.saveUser(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserResponse);
    }

    @GetMapping("/get")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> users = userServices.getAllUsers();
        if (!users.isEmpty()) {
            return ResponseEntity.ok(users); // Return a 200 OK response with the list of users
        } else {
            return ResponseEntity.noContent().build(); // Return a 204 No Content response if no users are found
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        UserResponse userResponse = userServices.getUserById(id);
        if (userResponse != null) {
            return ResponseEntity.ok(userResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable Long id,
            @RequestBody UserRequest userRequest) {
        UserResponse updatedUser = userServices.updateUser(id, userRequest);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser); // Return the updated user
        } else {
            return ResponseEntity.notFound().build(); // User with the given ID not found
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable Long id) {
        UserResponse deletedUser = userServices.deleteUser(id);
        if (deletedUser != null) {
            return ResponseEntity.ok(deletedUser); // Return the deleted user
        } else {
            return ResponseEntity.notFound().build(); // User with the given ID not found
        }
    }
}
