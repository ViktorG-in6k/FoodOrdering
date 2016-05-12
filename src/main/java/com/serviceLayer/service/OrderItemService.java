package com.serviceLayer.service;

import com.DTOLayer.DTOEntity.orderItemDTO.OrderItemDTO;
import com.model.Entity.OrderItem;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface OrderItemService {
    void saveOrderItem(OrderItem orderItem);

    void saveOrderItem(int itemId, int userId, int orderId);

    void addOneItemToOrder(Authentication authentication, int itemId, int orderId);

    void remoteOneItemFromOrder(Authentication authentication, int itemId, int orderId);

    void remotePositionFromOrder(Authentication authentication, int itemId, int orderId);

    List<OrderItemDTO> getOrderListByOrderIdAndUserId(int orderId, int userId);

    List<OrderItemDTO> getOrderListByOrderId(int orderId);

    void updateItemAmountInOrder(Authentication authentication, int orderId, int itemId, int number);
}
