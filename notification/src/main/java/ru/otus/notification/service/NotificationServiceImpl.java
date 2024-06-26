package ru.otus.notification.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.notification.model.Notification;
import ru.otus.notification.repository.NotificationRepository;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;


    @Override
    @Transactional
    public void sendNotification(Notification notification) {
        notificationRepository.save(notification);
    }

    @Override
    public Notification getNotificationByOrderId(Long orderId) {
        return notificationRepository.findByOrderId(orderId).orElseThrow(
                () -> new EntityNotFoundException("Уведомление не найдено!")
        );
    }
}
