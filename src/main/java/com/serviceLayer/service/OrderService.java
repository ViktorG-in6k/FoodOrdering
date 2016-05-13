package com.serviceLayer.service;

import com.dataLayer.entity.DTO.orderDTO.OrderPlacementStatus;
import com.dataLayer.entity.DTO.orderItemDTO.OrderItemRequest;
import com.dataLayer.entity.base.Order;
import com.dataLayer.entity.base.Status;
import org.springframework.security.core.Authentication;

import java.io.IOException;

public interface OrderService {
    void save(Order order);

    void save(OrderItemRequest req);

    void sendOrderToSplitBill(int orderId) throws IOException;

    void setPayerById(int orderId, int payerId);

    void removePayer(int orderId);

    Order getOrderById(int orderId);

    OrderPlacementStatus getOrderPlacementStatus(Order order, int restaurantId, int eventId, Authentication authentication);

    Order getOrdersByEventIdAndRestaurantId(int eventId, int restaurantId);

    boolean isMineOrder(Order order, Authentication authentication);

    void changeOrderStatus(int orderId, Status status) throws IOException;
}

