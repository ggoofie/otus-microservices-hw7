package ru.otus.order.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WithdrawalAccountDTO {
    private String username;
    private Double amount;
}
