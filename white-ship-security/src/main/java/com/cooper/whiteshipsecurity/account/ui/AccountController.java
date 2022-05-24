package com.cooper.whiteshipsecurity.account.ui;

import com.cooper.whiteshipsecurity.account.application.AccountService;
import com.cooper.whiteshipsecurity.account.dto.AccountCreateRequestDTO;
import com.cooper.whiteshipsecurity.account.dto.AccountCreateResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountCreateResponseDTO> create(@RequestBody AccountCreateRequestDTO accountCreateRequestDTO) {
        log.debug("{} : {}", AccountController.class.getName(), accountCreateRequestDTO);
        AccountCreateResponseDTO accountCreateResponseDTO = accountService.save(accountCreateRequestDTO);
        return ResponseEntity.ok(accountCreateResponseDTO);
    }

}
