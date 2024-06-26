package ru.otus.notification.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_notification")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    @Column(name = "order_id")
    private long orderId;

    @Column(name = "order_status")
    private String orderStatus;

    private String description;

}
