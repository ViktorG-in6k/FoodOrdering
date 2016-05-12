package com.serviceLayer.service;

import com.dataLayer.entity.DTO.orderDTO.OrderPlacementStatus;
import com.dataLayer.entity.DTO.orderItemDTO.OrderItemRequest;
import com.dataLayer.entity.Event;
import com.dataLayer.entity.Order;
import org.springframework.security.core.Authentication;

public interface OrderService {

    void save(Order order);

    void save(OrderItemRequest req);

    void setPayerById(int orderId, int payerId);

    Order getOrderByEvent(Event event);

    Order getOrderById(int orderId);

    OrderPlacementStatus getOrderPlacementStatus(Order order, int restaurantId, int eventId, Authentication authentication);

    Order getOrdersByEventIdAndRestaurantId(int eventId, int restaurantId);

    boolean isMineOrder(Order order, Authentication authentication);


}
