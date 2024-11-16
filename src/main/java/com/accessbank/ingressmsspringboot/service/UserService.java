package com.accessbank.ingressmsspringboot.service;


import com.accessbank.ingressmsspringboot.dao.CreateUserRequest;
import com.accessbank.ingressmsspringboot.dao.LoginUser;
import com.accessbank.ingressmsspringboot.dao.UpdateUserPassword;
import com.accessbank.ingressmsspringboot.dao.UserResponse;
import com.accessbank.ingressmsspringboot.mapper.UserMapper;
import com.accessbank.ingressmsspringboot.model.User;
import com.accessbank.ingressmsspringboot.predicate.user.UserDatePeridcate;
import com.accessbank.ingressmsspringboot.predicate.user.UserIsActivePeridcate;
import com.accessbank.ingressmsspringboot.predicate.user.UserIsPremiumPeridcate;
import com.accessbank.ingressmsspringboot.predicate.user.UserPaymentPeridcate;
import com.accessbank.ingressmsspringboot.security.PasswordUtil;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(makeFinal = true, level = PRIVATE)
@RequiredArgsConstructor
public class UserService {

    UserMapper userMapper;
    HashMap<String, User> users = new HashMap<>();


    public UserResponse createUser(CreateUserRequest createUserRequest) {
        if (createUserRequest == null) {
            throw new RuntimeException("data is null");
        }
        User user = userMapper.mapToUser(createUserRequest);
        users.put(user.getId(), user);
        return userMapper.mapToUserResponse(user);
    }

    public void updatePassword(UpdateUserPassword userPassword) {
        if (userPassword == null) {
            throw new RuntimeException("data is null");
        }
        User user = users.get(userPassword.getId());
        if (user == null) {
            throw new RuntimeException("user not found");
        }
        if (PasswordUtil.verifyPassword(userPassword.getOldPassword(), user.getPasswordHash())) {
            user.setPasswordHash(PasswordUtil.hashPassword(userPassword.getNewPassword()));
        } else {
            throw new RuntimeException("wrong password");
        }
    }

    public String loginUser(LoginUser loginUser) {

        User findedUser = null;
        for (User user : users.values()) {
            if (user.getUsername().equals(loginUser.getUsername())) {
                findedUser = user;
                break;
            }
        }
        if (loginUser == null) {
            throw new RuntimeException("user not found");
        }
        if (PasswordUtil.verifyPassword(loginUser.getPassword(), findedUser.getPasswordHash())) {
            return "create access token";
        } else
            throw new RuntimeException("wrong password ");


    }

    public void updateUserName(String id, String username) {
        User user = users.get(id);
        user.setUsername(username);

    }

    public Collection<UserResponse> getUsers(Float minPaymentAmount,
                                             Float maxPaymentAmount,
                                             Boolean isActiveAccount,
                                             Boolean isPremiumAccount,
                                             LocalDate fromDate,
                                             LocalDate toDate) {

        List<User> filteredUsers = users.values().stream()
                .filter(new UserPaymentPeridcate(minPaymentAmount,maxPaymentAmount))
                .filter(new UserDatePeridcate(fromDate, toDate))
                .filter(new UserIsActivePeridcate(isActiveAccount))
                .filter(new UserIsPremiumPeridcate(isPremiumAccount))
                .toList();

        return userMapper.mapToUserResponse(filteredUsers);




    }


}
