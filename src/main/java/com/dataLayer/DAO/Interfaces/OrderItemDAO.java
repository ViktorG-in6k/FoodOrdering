package com.dataLayer.DAO.Interfaces;

import com.dataLayer.entity.OrderItem;

import java.util.List;

public interface OrderItemDAO {
    void saveOrderItem(OrderItem orderItem);

    OrderItem getOrderItem(int userId, int itemId, int orderId);

    List<OrderItem> getOrderListByOrderIdAndUserId(int userId, int orderId);

    List<OrderItem> getOrderListByOrderId(int orderId);

    void updateAmount(OrderItem orderItem, int amount);

    void deleteOrderItem(OrderItem orderItem);
}

