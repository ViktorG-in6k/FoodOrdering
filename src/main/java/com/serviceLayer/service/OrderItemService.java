package com.serviceLayer.service;

import com.model.Entity.OrderItem;

import javax.servlet.http.HttpSession;

public interface OrderItemService {
    void saveOrderItem(OrderItem orderItem);

    void saveOrderItem(int itemId, int userId);

    void addOneItemToOrder(HttpSession session, int itemId, int orderId);

    void updateItemAmountInOrder(HttpSession session, int orderId, int itemId, int number);
}
