package ru.otus.order.service;

import ru.otus.order.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrdersByUsername(String username);
    Order createOrder(Order order);
}
