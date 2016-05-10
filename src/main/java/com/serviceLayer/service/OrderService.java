package com.serviceLayer.service;

import com.DTOLayer.DTOEntity.orderDTO.OrderPlacementStatus;
import com.DTOLayer.DTOEntity.orderItemDTO.OrderItemRequest;
import com.googleAuthentication.CurrentUserDetails;
import com.model.Entity.Event;
import com.model.Entity.Order;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpSession;

public interface OrderService {

    void save(Order order);

    void save(OrderItemRequest req);

    Order getOrderByEvent(Event event);

    Order getOrderById(int orderId);

    OrderPlacementStatus getOrderPlacementStatus(Order order,int restaurantId,int eventId, Authentication authentication);

    Order getOrdersByEventIdAndRestaurantId(int eventId, int restaurantId);

    boolean isMineOrder(Order order, Authentication authentication);


}
