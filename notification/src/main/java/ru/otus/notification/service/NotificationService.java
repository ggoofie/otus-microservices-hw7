package ru.otus.notification.service;

import ru.otus.notification.model.Notification;

public interface NotificationService {
    void sendNotification(Notification notification);
    Notification getNotificationByOrderId(Long orderId);
}
