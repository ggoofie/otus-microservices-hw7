package ru.otus.notification.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.notification.dto.NotificationDTO;
import ru.otus.notification.service.NotificationService;

@RestController
@RequestMapping("/api/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/{orderId}")
    public NotificationDTO getNotificationByOrderId(@PathVariable Long orderId) {
        var notification = notificationService.getNotificationByOrderId(orderId);
        return NotificationDTO.builder()
                .orderId(notification.getOrderId())
                .orderStatus(notification.getOrderStatus().toString())
                .description(notification.getDescription())
                .build();
    }
}
