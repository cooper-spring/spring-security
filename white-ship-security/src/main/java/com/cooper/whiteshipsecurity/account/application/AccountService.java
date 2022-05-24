package com.cooper.whiteshipsecurity.account.application;

import com.cooper.whiteshipsecurity.account.domain.Account;
import com.cooper.whiteshipsecurity.account.domain.AccountRepository;
import com.cooper.whiteshipsecurity.account.dto.AccountCreateRequestDTO;
import com.cooper.whiteshipsecurity.account.dto.AccountCreateResponseDTO;
import com.cooper.whiteshipsecurity.account.exception.NotFoundAccountException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;


    public AccountCreateResponseDTO save(AccountCreateRequestDTO accountCreateRequestDTO) {
        Account account = accountCreateRequestDTO.toEntity();
        Account savedAccount = accountRepository.save(account);
        return AccountCreateResponseDTO.fromEntity(savedAccount);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(username)
                .orElseThrow(() -> new NotFoundAccountException(username));

        return User.builder()
                .username(account.getEmail())
                .password(passwordEncoder.encode(account.getPassword()))
                .build();
    }

}
