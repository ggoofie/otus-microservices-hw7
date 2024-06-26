package ru.otus.order.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String description;

    private Double price;

    @Enumerated(EnumType.STRING)
    private Status status;
}
