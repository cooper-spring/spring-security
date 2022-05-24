package com.cooper.whiteshipsecurity.account.dto;

import com.cooper.whiteshipsecurity.account.domain.Account;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AccountCreateResponseDTO {

    private final long id;

    public static AccountCreateResponseDTO fromEntity(Account account) {
        return new AccountCreateResponseDTO(account.getId());
    }

}
