package com.accessbank.ingressmsspringboot.mapper;

import com.accessbank.ingressmsspringboot.dao.CreateUserRequest;
import com.accessbank.ingressmsspringboot.dao.UserResponse;
import com.accessbank.ingressmsspringboot.model.User;
import com.accessbank.ingressmsspringboot.security.PasswordUtil;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Component
public class UserMapper {

    public User mapToUser(CreateUserRequest userRequest) {
        if (userRequest == null) {
            throw new RuntimeException("data is null");
        }

        String passwordHashWithSalt = PasswordUtil.hashPassword(userRequest.getPassword());
        return User.builder()
                .id(UUID.randomUUID().toString())
                .username(userRequest.getUsername())
                .isPremiumAccount(userRequest.isPremiumAccount())
                .isActiveAccount(userRequest.isActiveAccount())
                .moneyAmount(userRequest.getMoneyAmount())
                .passwordHash(passwordHashWithSalt)
                .createdDate(LocalDate.now())
                .build();
    }

    public UserResponse mapToUserResponse(User user) {
        if (user == null) {
            throw new RuntimeException("data is null");
        }

        return UserResponse.builder()
                .username(user.getUsername())
                .moneyAmount(user.getMoneyAmount())
                .id(user.getId())
                .isPremiumAccount(user.isPremiumAccount())
                .isActiveAccount(user.isActiveAccount())
                .build();

    }

    public Collection<UserResponse> mapToUserResponse(Collection<User> users) {
        if (users == null) {
            throw new RuntimeException("data is null");
        }
        return users.stream() // Stream the collection
                .map(this::mapToUserResponse) // Map each User to UserResponse
                .collect(Collectors.toList()); // Collect the results into a list

    }


}
