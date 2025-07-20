package com.pos_app.pos_app.services.Impl;

import com.pos_app.pos_app.domain.dto.UserRequestDto;
import com.pos_app.pos_app.domain.dto.UserDto;
import com.pos_app.pos_app.domain.entity.User;
import com.pos_app.pos_app.mapper.UserMapper;
import com.pos_app.pos_app.repository.UserRepository;
import com.pos_app.pos_app.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private  final UserRepository userRepository;
    private final UserMapper userMapper;


    @Override
    public UserDto createUser(UserRequestDto userRequestDto) {
        User user = User.builder()
                .userName(userRequestDto.getUserName())
                .fullName(userRequestDto.getFullName())
                .phoneNo(userRequestDto.getPhoneNo())
                .password(userRequestDto.getPassword())
                .role(userRequestDto.getRole())
                .build();

        User savedUser = userRepository.save(user);

        return userMapper.toDTO(savedUser);
    }


    @Override
    public List<UserDto> listUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserDto updateUser(UserRequestDto userRequestDto, UUID userId) {
        // Fetch the existing user
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        // Update only non-null and non-empty fields from the request
        if (userRequestDto.getUserName() != null && !userRequestDto.getUserName().isEmpty()) {
            existingUser.setUserName(userRequestDto.getUserName());
        }

        if (userRequestDto.getFullName() != null && !userRequestDto.getFullName().isEmpty()) {
            existingUser.setFullName(userRequestDto.getFullName());
        }

        if (userRequestDto.getPhoneNo() != null && !userRequestDto.getPhoneNo().isEmpty()) {
            existingUser.setPhoneNo(userRequestDto.getPhoneNo());
        }

        if (userRequestDto.getPassword() != null && !userRequestDto.getPassword().isEmpty()) {
            existingUser.setPassword(userRequestDto.getPassword());
        }

        if (userRequestDto.getRole() != null) {
            existingUser.setRole(userRequestDto.getRole());
        }

        // Save updated user
        User updatedUser = userRepository.save(existingUser);

        // Map back to UserDto and return
        return userMapper.toDTO(updatedUser);
    }



    @Override
    public UserDto getUserById(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("No User found with ID: " + userId));
        return userMapper.toDTO(user);
    }

    @Override
    public void deleteUser(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("No User found with ID: " + userId));
        userRepository.delete(user);
    }
}
