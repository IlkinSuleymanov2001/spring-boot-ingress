package com.accessbank.ingressmsspringboot.predicate.user;

import com.accessbank.ingressmsspringboot.model.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.function.Predicate;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserDatePeridcate implements Predicate<User> {


    LocalDate fromDate;
    LocalDate toDate;


    @Override
    public boolean test(User t) {
        if (fromDate != null && toDate != null) {
            return t.getCreatedDate().isAfter(fromDate) && t.getCreatedDate().isBefore(toDate);
        }
        if (fromDate != null) {
            return t.getCreatedDate().isAfter(fromDate);
        }
        if (toDate != null) {
            return t.getCreatedDate().isBefore(toDate);
        }
        return true;
    }


}