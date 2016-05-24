package com.serviceLayer.service;

import com.dataLayer.entity.DTO.orderItemDTO.OrderItemDTO;
import com.dataLayer.entity.base.OrderItem;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface OrderItemService {
    void saveOrderItem(OrderItem orderItem);

    void saveOrderItem(int itemId, int userId, int orderId);

    void addOneItemToOrder(int userId, int itemId, int orderId);

    void remoteOneItemFromOrder(int userId, int itemId, int orderId);

    void remotePositionFromOrder(int userId, int itemId, int orderId);

    List<OrderItemDTO> getOrderListByOrderIdAndUserId(int orderId, int userId);

    List<OrderItemDTO> getOrderListByOrderIdAndItemId(int orderId, int itemId);

    List<OrderItemDTO> getOrderItemListDTOByOrderId(int orderId);

    void updateItemAmountInOrder(Authentication authentication, int orderId, int itemId, int number);

    List<OrderItemDTO> getOrderCommonListById(int orderId);

    List<OrderItem> getOrderListByOrderId(int id);

    List<OrderItemDTO> getOrderItemDtoSortedByUser(int orderId, int itemId);
}
