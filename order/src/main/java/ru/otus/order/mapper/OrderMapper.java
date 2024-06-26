package ru.otus.order.mapper;

import org.springframework.stereotype.Component;
import ru.otus.order.dto.CreateOrderDTO;
import ru.otus.order.dto.OrderDTO;
import ru.otus.order.model.Order;
import ru.otus.order.model.Status;

@Component
public class OrderMapper {
    public OrderDTO orderToDTO(Order order) {
        return OrderDTO.builder()
                .id(order.getId())
                .description(order.getDescription())
                .price(order.getPrice())
                .status(order.getStatus().toString())
                .build();
    }

    public Order fromCreateOrderDTOtoOrder(CreateOrderDTO createOrderDTO) {
        return new Order(null,
                createOrderDTO.getUsername(),
                createOrderDTO.getDescription(),
                createOrderDTO.getPrice(),
                Status.OPEN);
    }
}
