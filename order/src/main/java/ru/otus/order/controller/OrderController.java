package ru.otus.order.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.otus.order.dto.CreateOrderDTO;
import ru.otus.order.dto.OrderDTO;
import ru.otus.order.mapper.OrderMapper;
import ru.otus.order.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping("/{username}")
    public List<OrderDTO> getOrdersByUsername(@PathVariable String username) {
        return orderService.getOrdersByUsername(username).stream()
                .map(orderMapper::orderToDTO)
                .toList();
    }

    @PostMapping
    public OrderDTO createOrder(@RequestBody CreateOrderDTO createOrderDTO) {
        var order = orderService.createOrder(orderMapper.fromCreateOrderDTOtoOrder(createOrderDTO));
        return orderMapper.orderToDTO(order);
    }
}
