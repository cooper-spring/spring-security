package com.cooper.whiteshipsecurity.account.dto;

import com.cooper.whiteshipsecurity.account.domain.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public class AccountCreateRequestDTO {

    private final String email;

    private final String password;

    public Account toEntity() {
        return new Account(email, password);
    }

}
