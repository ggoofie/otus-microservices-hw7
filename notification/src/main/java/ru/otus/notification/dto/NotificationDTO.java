package ru.otus.notification.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationDTO {
    private Long orderId;
    private String orderStatus;
    private String description;
}
