package ru.otus.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class OrderDTO {
    private long id;
    private String description;
    private double price;
    private String status;
}
