package ru.otus.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.otus.order.dto.NoticeMessage;
import ru.otus.order.model.Order;

@Service
@RequiredArgsConstructor
public class KafkaService {

    private final KafkaTemplate<String, NoticeMessage> kafkaTemplate;

    public void sendNoticeMessage(Order order) {
        kafkaTemplate.send("notice-topic",
                NoticeMessage.builder()
                        .orderId(order.getId())
                        .orderStatus(order.getStatus().toString())
                        .username(order.getUsername())
                        .orderDescription(order.getDescription())
                        .build());
    }
}
