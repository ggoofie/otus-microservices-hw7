package ru.otus.order.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.order.dto.NoticeMessage;
import ru.otus.order.dto.WithdrawalAccountDTO;
import ru.otus.order.model.Order;
import ru.otus.order.model.Status;
import ru.otus.order.repository.OrderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final BillingService billingService;
    private final KafkaService kafkaService;

    @Override
    public List<Order> getOrdersByUsername(String username) {
        return orderRepository.findByUsername(username);
    }

    @Override
    public Order createOrder(Order order) {
        var savedOrder = orderRepository.saveAndFlush(order);
        try {
            billingService.withdrawal(
                    WithdrawalAccountDTO.builder()
                            .username(savedOrder.getUsername())
                            .amount(savedOrder.getPrice())
                            .build()
            );
            savedOrder.setStatus(Status.COMPLETED);
            orderRepository.save(savedOrder);
        } catch (Exception ex) {
            savedOrder.setStatus(Status.REJECTED);
            orderRepository.saveAndFlush(savedOrder);
            throw ex;
        } finally {
            kafkaService.sendNoticeMessage(savedOrder);
        }
        return savedOrder;
    }
}
