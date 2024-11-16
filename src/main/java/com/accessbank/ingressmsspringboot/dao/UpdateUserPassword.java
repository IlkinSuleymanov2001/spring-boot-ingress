package com.accessbank.ingressmsspringboot.dao;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateUserPassword {
    String id;
    String oldPassword;
    String newPassword;
    String confirmNewPassword;
}
