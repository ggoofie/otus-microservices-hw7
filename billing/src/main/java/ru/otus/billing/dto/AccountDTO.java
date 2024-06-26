package ru.otus.billing.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class AccountDTO {
    private UUID id;
    private String username;
}
