package ru.otus.billing.service;

import ru.otus.billing.model.Account;


public interface AccountService {
    Account createAccount(Account account);
    void refillAccount(String username, Double amount);
    void withdrawalAccount(String username, Double amount);
    Double balance(String username);
}
