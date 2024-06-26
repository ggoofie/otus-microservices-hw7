package ru.otus.notification.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeMessage {
    private Long orderId;
    private String username;
    private String orderDescription;
    private String orderStatus;
}
