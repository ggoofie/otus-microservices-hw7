package ru.otus.billing.dto;

import lombok.Data;

@Data
public class RefillAccountDTO {
    private String username;
    private Double amount;
}
