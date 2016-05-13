package com.serviceLayer.service;

import com.DTOLayer.DTOEntity.orderDTO.OrderPlacementStatus;
import com.model.Entity.Event;
import com.model.Entity.Order;

import javax.servlet.http.HttpSession;

public interface OrderService {

    void save(Order order);

    Order getOrderByEvent(Event event);

    Order getOrderById(int orderId);

    OrderPlacementStatus getOrderPlacementStatus(Order order,int restaurantId,int eventId, HttpSession session);

    Order getOrdersByEventIdAndRestaurantId(int eventId, int restaurantId);

    boolean isMineOrder(Order order, HttpSession session);
}
