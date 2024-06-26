package ru.otus.billing.mapper;

import org.springframework.stereotype.Component;
import ru.otus.billing.dto.AccountDTO;
import ru.otus.billing.dto.CreateAccountDTO;
import ru.otus.billing.model.Account;

@Component
public class AccountMapper {
    public Account fromCreateAccountDTOtoAccount(CreateAccountDTO createAccountDTO) {
        return new Account(null, createAccountDTO.getUsername(), 0.00);
    }

    public AccountDTO fromAccountToAccountDTO(Account account) {
        return new AccountDTO(account.getId(), account.getUsername());
    }
}
