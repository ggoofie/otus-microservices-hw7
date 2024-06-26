package ru.otus.billing.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.otus.billing.dto.AccountDTO;
import ru.otus.billing.dto.CreateAccountDTO;
import ru.otus.billing.dto.RefillAccountDTO;
import ru.otus.billing.dto.WithdrawalAccountDTO;
import ru.otus.billing.mapper.AccountMapper;
import ru.otus.billing.service.AccountService;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @GetMapping("/balance/{username}")
    public Double balance(@PathVariable String username) {
        return accountService.balance(username);
    }

    @PostMapping
    public AccountDTO createAccount(@RequestBody CreateAccountDTO createAccountDTO) {
        var account =
                accountService.createAccount(accountMapper.fromCreateAccountDTOtoAccount(createAccountDTO));
        return accountMapper.fromAccountToAccountDTO(account);
    }

    @PatchMapping("/refill")
    public void refillAccount(@RequestBody RefillAccountDTO refillAccountDTO) {
        accountService.refillAccount(
                refillAccountDTO.getUsername(),
                refillAccountDTO.getAmount());
    }

    @PatchMapping("/withdrawal")
    public void withdrawal(@RequestBody WithdrawalAccountDTO withdrawalAccountDTO) {
        accountService.withdrawalAccount(
                withdrawalAccountDTO.getUsername(),
                withdrawalAccountDTO.getAmount());
    }
}
