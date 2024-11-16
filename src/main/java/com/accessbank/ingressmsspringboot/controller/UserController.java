package com.accessbank.ingressmsspringboot.controller;

import com.accessbank.ingressmsspringboot.dao.CreateUserRequest;
import com.accessbank.ingressmsspringboot.dao.LoginUser;
import com.accessbank.ingressmsspringboot.dao.UpdateUserPassword;
import com.accessbank.ingressmsspringboot.dao.UserResponse;
import com.accessbank.ingressmsspringboot.response.Response;
import com.accessbank.ingressmsspringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class UserController {

    UserService userService;

    @PostMapping("register")
    @ResponseStatus(CREATED)
    public Response<UserResponse> registerUser(@RequestBody CreateUserRequest userRequest) {
        UserResponse user = userService.createUser(userRequest);
        return Response.<UserResponse>builder()
                .status(202)
                .success(true)
                .response(user)
                .build();

    }

    @PutMapping("change/password")
    @ResponseStatus(OK)
    public Response<Object> registerUser(@RequestBody UpdateUserPassword password) {
        userService.updatePassword(password);
        return Response.builder()
                .status(200)
                .success(true)
                .build();
    }

    @PutMapping("login")
    @ResponseStatus(OK)
    public Response<Object> login(@RequestBody LoginUser user) {
        String token = userService.loginUser(user);
        return Response.builder()
                .response(token)
                .status(200)
                .success(true)
                .build();
    }

    @PatchMapping("/{id}/update/username")
    @ResponseStatus(NO_CONTENT)
    public void updateUsername(@PathVariable String id,
                               @RequestParam String username) {
        userService.updateUserName(id, username);
    }

    @GetMapping("/all/filter")
    @ResponseStatus(OK)
    public Response<Collection<UserResponse>> getUsers(Float minPaymentAmount,
                                                       Float maxPaymentAmount,
                                                       Boolean isActiveAccount,
                                                       Boolean isPremiumAccount,
                                                       LocalDate fromDate,
                                                       LocalDate toDate) {

        Collection<UserResponse> users = userService.getUsers(minPaymentAmount, maxPaymentAmount,isActiveAccount, isPremiumAccount, fromDate, toDate);
        return Response.<Collection<UserResponse>>builder()
                .success(true)
                .response(users)
                .status(200)
                .build();
    }


}
