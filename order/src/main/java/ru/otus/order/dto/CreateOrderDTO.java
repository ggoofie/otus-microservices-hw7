package ru.otus.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CreateOrderDTO {
    private String username;
    private double price;
    private String description;
}
