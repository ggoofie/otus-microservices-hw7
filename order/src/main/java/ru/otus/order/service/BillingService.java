package ru.otus.order.service;

import ru.otus.order.dto.WithdrawalAccountDTO;

public interface BillingService {
    void withdrawal(WithdrawalAccountDTO withdrawalAccountDTO);
}
