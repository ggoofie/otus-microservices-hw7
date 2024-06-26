package ru.otus.billing.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import ru.otus.billing.model.Account;
import ru.otus.billing.repository.AccountRepository;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        accountRepository.findByUsername(account.getUsername()).ifPresent(
                ex -> {throw new DuplicateKeyException("Счет уже существует!");});
        return accountRepository.save(account);
    }

    @Override
    public void refillAccount(String username, Double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Неверное значение пополнения!");
        }
        var account = findAccount(username);
        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);
    }

    @Override
    public void withdrawalAccount(String username, Double amount) {
        var account = findAccount(username);
        if (amount > account.getBalance()) {
            throw new IllegalArgumentException("Неверное значение списания!");
        }
        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);
    }

    @Override
    public Double balance(String username) {
        return findAccount(username).getBalance();
    }

    private Account findAccount(String username) {
        return accountRepository.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("Счет не найден!"));
    }
}
