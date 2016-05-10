package com.serviceLayer.service;

import com.DTOLayer.DTOEntity.orderDTO.OrderPlacementStatus;
import com.DTOLayer.DTOEntity.orderItemDTO.OrderItemRequest;
import com.model.Entity.Event;
import com.model.Entity.Order;

import javax.servlet.http.HttpSession;

public interface OrderService {

    void save(Order order);

    void save(OrderItemRequest req, HttpSession session);

    Order getOrderByEvent(Event event);

    Order getOrderById(int orderId);

    OrderPlacementStatus getOrderPlacementStatus(Order order,int restaurantId,int eventId, HttpSession session);

    boolean isMineOrder(Order order, HttpSession session);
}
