package com.dataLayer.DAO;

import com.model.Entity.OrderItem;

public interface OrderItemDAO {
    void saveOrderItem(OrderItem orderItem);

    OrderItem getOrderItem(int userId, int itemId, int orderId);

    void updateAmount(OrderItem orderItem, int amount);
}
