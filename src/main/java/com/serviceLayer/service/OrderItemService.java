package com.serviceLayer.service;

import com.DTOLayer.DTOEntity.orderItemDTO.OrderItemDTO;
import com.model.Entity.OrderItem;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface OrderItemService {
    void saveOrderItem(OrderItem orderItem);

    void saveOrderItem(int itemId, int userId, int orderId);

    void addOneItemToOrder(HttpSession session, int itemId, int orderId);

    List<OrderItemDTO> getOrderListByOrderIdAndUserId(int orderId, int userId);

    void updateItemAmountInOrder(Authentication authentication, int orderId, int itemId, int number);
}
