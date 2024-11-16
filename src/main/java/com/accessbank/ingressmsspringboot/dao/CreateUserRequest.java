package com.accessbank.ingressmsspringboot.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateUserRequest {

    @JsonProperty("username")
    String username;

    @JsonProperty("password")
    String password;

    @JsonProperty("isActiveAccount")
    boolean isActiveAccount;

    @JsonProperty("isPremiumAccount")
    boolean isPremiumAccount;

    @JsonProperty("moneyAmount")
    float moneyAmount;


}
