package com.accessbank.ingressmsspringboot.dao;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {

    String id;
    String username;
    @JsonProperty("isActiveAccount")
    boolean isActiveAccount;
    @JsonProperty("isPremiumAccount")
    boolean isPremiumAccount;
    float moneyAmount;
}
