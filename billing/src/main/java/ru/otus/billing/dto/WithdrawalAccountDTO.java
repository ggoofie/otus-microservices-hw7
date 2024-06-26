package ru.otus.billing.dto;

import lombok.Data;

@Data
public class WithdrawalAccountDTO {
    private String username;
    private Double amount;
}
