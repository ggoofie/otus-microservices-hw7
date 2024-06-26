package ru.otus.order.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoticeMessage {
    private Long orderId;
    private String username;
    private String orderDescription;
    private String orderStatus;
}
