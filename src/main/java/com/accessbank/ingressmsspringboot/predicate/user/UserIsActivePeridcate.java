package com.accessbank.ingressmsspringboot.predicate.user;

import com.accessbank.ingressmsspringboot.model.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.function.Predicate;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE,makeFinal = true)
@RequiredArgsConstructor
public class UserIsActivePeridcate implements Predicate<User> {

    Boolean isActiveAccount;

    @Override
    public boolean test(User t) {
        if (isActiveAccount==null) return true;
        return t.isActiveAccount()==isActiveAccount;
    }


}