package com.dataLayer.DAO.Interfaces;

import com.dataLayer.entity.Order;

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

    void removePayer(int orderId);

    void setPayer(int eventId, int restaurantId, int payerId);
}

