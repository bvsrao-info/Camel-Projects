package camelinaction;

import java.util.Optional;

import camelinaction.jpa.entity.OrderJpa;

public interface OrderService {

    Optional<OrderJpa> getOrder(int orderId);

    String updateOrder(OrderJpa orderJpa);

    String createOrder(OrderJpa orderJpa);

    String cancelOrder(int orderId);

    Orders getOrders();
}
