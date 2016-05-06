package com.dataLayer.DAO;

import com.model.Entity.Order;

import java.util.List;

public interface OrderDAO {
    void save(Order order);

    Order getOrderByEventIdAndRestaurantIdAndPayerId(int eventId, int restaurantId, int payerId);

    Order getOrdersByEventIdAndRestaurantId(int eventId, int restaurantId);

    Order getOrderByOrderId(int orderId);

    List<Order> getOrdersByEventId(int eventId);

    List<Order> getOrdersByRestaurantId(int restaurantId);

    void setPayerForOrder(int orderId, int payerId);

    void setPayerForOrder(int eventId, int restaurantId, int payerId);
}


