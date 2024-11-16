package com.accessbank.ingressmsspringboot.predicate.user;

import com.accessbank.ingressmsspringboot.model.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.function.Predicate;

import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE,makeFinal = true)
@RequiredArgsConstructor
public class UserPaymentPeridcate implements Predicate<User> {

    Float minPaymentAmount;
    Float maxPaymentAmount;

    @Override
    public boolean test(User t) {
        if (minPaymentAmount != null && maxPaymentAmount != null) {
            return t.getMoneyAmount() > minPaymentAmount && t.getMoneyAmount() <= maxPaymentAmount;
        }
        if (minPaymentAmount != null) {
            return t.getMoneyAmount() > minPaymentAmount;
        }
        if (maxPaymentAmount != null) {
            return t.getMoneyAmount() <= maxPaymentAmount;
        }
            return true;
    }


}