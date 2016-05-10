package com.dataLayer.DAO;

import com.model.Entity.Order;
import com.model.Entity.Status;

import java.util.List;

public interface OrderDAO {
    void saveOrder(Order order);

    Order getOrderByEventIdAndRestaurantIdAndPayerId(int eventId, int restaurantId, int payerId);

    Order getOrdersByEventIdAndRestaurantId(int eventId, int restaurantId);

    Order getOrderByOrderId(int orderId);

    List<Order> getOrdersByEventId(int eventId);

    Order getOrderByEventId(int eventId);

    List<Order> getOrdersByRestaurantId(int restaurantId);

    void setPayer(int orderId, int payerId);

    void setPayer(int eventId, int restaurantId, int payerId);

    void setStatus(int orderId, int statusId);

    Status getStatus(int statusId);
}


