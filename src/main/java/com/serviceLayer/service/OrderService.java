package com.serviceLayer.service;

import com.dataLayer.entity.DTO.orderDTO.OrderPlacementStatus;
import com.dataLayer.entity.DTO.orderItemDTO.OrderItemRequest;
import com.dataLayer.entity.base.Order;
import com.dataLayer.entity.base.Status;
import org.springframework.security.core.Authentication;

import java.io.IOException;
import java.util.List;

public interface OrderService {
    void save(Order order);

    void save(OrderItemRequest req);

    void setPayerById(int orderId, int payerId);

    void removePayer(int orderId);

    Order getOrderById(int orderId);

    OrderPlacementStatus getOrderPlacementStatus(Order order, Authentication authentication);

    List<Order> getOrdersByEventIdAndRestaurantId(int eventId, int restaurantId);

    List<Order> getOrdersByEventIdAndRestaurantIdAndStatus(int eventId, int restaurantId, Status status);

    OrderPlacementStatus getOrderPlacementStatusByOrderId(Order order, Authentication authentication);

    boolean isMineOrder(Order order, Authentication authentication);

    void changeOrderStatus(int orderId, Status status, int splitBillId) throws IOException;

    Order createOrder(int eventId, int restaurantId);

    void sendOrderToSplitBill(int orderId, int splitBillId) throws IOException;

    List<OrderPlacementStatus> getOrderPlacementStatusByEventIdAndRestaurantId(int eventId, int restaurantId, Authentication authentication);

    void updatePercentageDiscount(int orderId, double percentageDiscount);
}


