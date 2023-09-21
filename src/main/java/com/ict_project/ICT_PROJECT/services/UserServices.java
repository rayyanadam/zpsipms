package com.ict_project.ICT_PROJECT.services;

import com.ict_project.ICT_PROJECT.dto.UserRequest;
import com.ict_project.ICT_PROJECT.dto.UserResponse;
import com.ict_project.ICT_PROJECT.model.UserModel;
import com.ict_project.ICT_PROJECT.repository.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Builder
@RequiredArgsConstructor
public class UserServices {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserResponse saveUser(UserRequest userRequest) {
        UserModel users = modelMapper.map(userRequest, UserModel.class);
        users = userRepository.save(users);
        return modelMapper.map(users, UserResponse.class);
    }

    public List<UserResponse> getAllUsers() {
        List<UserModel> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserResponse.class))
                .collect(Collectors.toList());
    }

    public UserResponse getUserById(Long id) {
        Optional<UserModel> userOptional = userRepository.findById(id);
        return userOptional.map(user -> modelMapper.map(user, UserResponse.class)).orElse(null);
    }

    public UserResponse updateUser(Long id, UserRequest userRequest) {
        Optional<UserModel> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserModel existingUser = optionalUser.get();

            // Update the user fields based on the DTO
            if (userRequest.getUserName() != null) {
                existingUser.setUserName(userRequest.getUserName());
            }
            if (userRequest.getPosition() != null) {
                existingUser.setPosition(userRequest.getPosition());
            }
            if (userRequest.getPassword() != null) {
                existingUser.setPassword(userRequest.getPassword());
            }
            // Save the updated user
            existingUser = userRepository.save(existingUser);

            // Convert and return the updated user as a response DTO
            return modelMapper.map(existingUser, UserResponse.class);
        } else {
            return null;
        }
    }

    public UserResponse deleteUser(Long id) {
        Optional<UserModel> userToDelete = userRepository.findById(id);
        if (userToDelete.isPresent()) {
            userRepository.deleteById(id);
            return modelMapper.map(userToDelete.get(), UserResponse.class);
        } else {
            return null;
        }
    }
}
