package ru.otus.notification.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.otus.notification.dto.NoticeMessage;
import ru.otus.notification.model.Notification;

@Service
@RequiredArgsConstructor
public class KafkaService {

    private final NotificationService notificationService;

    @KafkaListener(
            topics = "notice-topic",
            containerFactory = "kafkaListenerContainerFactory")
    public void noticeListener(NoticeMessage noticeMessage) {
        notificationService.sendNotification(Notification.builder()
                .username(noticeMessage.getUsername())
                .orderId(noticeMessage.getOrderId())
                .orderStatus(noticeMessage.getOrderStatus())
                .description(noticeMessage.getOrderDescription())
                .build());
    }
}
