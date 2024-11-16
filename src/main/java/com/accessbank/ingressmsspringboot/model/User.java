package com.accessbank.ingressmsspringboot.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    String id;
    String username;
    String passwordHash;
    LocalDate createdDate;
    boolean isActiveAccount;
    boolean isPremiumAccount;
    float moneyAmount;


}
