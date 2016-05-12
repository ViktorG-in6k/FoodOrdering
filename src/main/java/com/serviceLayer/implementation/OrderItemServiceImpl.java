package com.serviceLayer.implementation;

import com.dataLayer.entity.DTO.orderItemDTO.OrderItemDTO;
import com.dataLayer.DAO.Interfaces.OrderItemDAO;
import com.serviceLayer.googleAuthentication.CurrentUserDetails;
import com.dataLayer.entity.Item;
import com.dataLayer.entity.Order;
import com.dataLayer.entity.OrderItem;
import com.dataLayer.entity.User;
import com.serviceLayer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemDAO orderItemDAO;
    @Autowired
    ItemService itemService;
    @Autowired
    UserService userService;
    @Autowired
    OrderService orderService;
    @Autowired
    EventService eventService;
    @Autowired
    RestaurantService restaurantService;

    @Override
    public void saveOrderItem(OrderItem orderItem) {
        orderItemDAO.saveOrderItem(orderItem);
    }

    @Override
    public void saveOrderItem(int itemId, int userId, int orderId) {
        Item item = itemService.getItemById(itemId);
        User user = userService.getUser(userId);
        Order order = orderService.getOrderById(orderId);
        saveOrderItem(new OrderItem(user, item, order));
    }

    @Override
    public void addOneItemToOrder(Authentication authentication, int itemId, int orderId) {
        int userId = ((CurrentUserDetails) authentication.getPrincipal()).getUser().getId();
        OrderItem orderInOrderList = orderItemDAO.getOrderItem(userId, itemId, orderId);
        if (orderInOrderList != null) {
            orderItemDAO.updateAmount(orderInOrderList, orderInOrderList.getItemAmount() + 1);
        } else {
            saveOrderItem(itemId, userId, orderId);
        }
    }

    @Override
    public void remoteOneItemFromOrder(Authentication authentication, int itemId, int orderId) {
        int userId = ((CurrentUserDetails) authentication.getPrincipal()).getUser().getId();
        OrderItem orderInOrderList = orderItemDAO.getOrderItem(userId, itemId, orderId);
        if(orderInOrderList.getItemAmount() - 1 != 0) {
            orderItemDAO.updateAmount(orderInOrderList, orderInOrderList.getItemAmount() - 1);
        }
        else {
            orderItemDAO.deleteOrderItem(orderInOrderList);
        }
    }

    @Override
    public void remotePositionFromOrder(Authentication authentication, int itemId, int orderId) {
        int userId = ((CurrentUserDetails) authentication.getPrincipal()).getUser().getId();
        OrderItem orderInOrderList = orderItemDAO.getOrderItem(userId, itemId, orderId);
        orderItemDAO.deleteOrderItem(orderInOrderList);
    }

    @Override
    public List<OrderItemDTO> getOrderListByOrderIdAndUserId(int orderId, int userId) {
        List<OrderItem> orderItems = orderItemDAO.getOrderListByOrderIdAndUserId(userId, orderId);
        List<OrderItemDTO> orderItemsDTO = new ArrayList<>();
        orderItems.forEach(orderItem -> orderItemsDTO.add(new OrderItemDTO(orderItem)));
        return orderItemsDTO;
    }

    @Override
    public List<OrderItemDTO> getOrderListByOrderId(int orderId) {
        List<OrderItem> orderItems = orderItemDAO.getOrderListByOrderId(orderId);
        List<OrderItemDTO> orderItemsDTO = new ArrayList<>();
        orderItems.forEach(orderItem -> orderItemsDTO.add(new OrderItemDTO(orderItem)));
        return orderItemsDTO;
    }

    @Override
    public void updateItemAmountInOrder(Authentication authentication, int orderId, int itemId, int number) {
        int userId = ((CurrentUserDetails) authentication.getPrincipal()).getUser().getId();
        OrderItem orderInOrderList = orderItemDAO.getOrderItem(userId, itemId, orderId);
        Order order = orderService.getOrderById(orderId);
        if (order != null) {
            if (orderInOrderList != null) {
                orderItemDAO.updateAmount(orderInOrderList, number);
            } else {
                saveOrderItem(itemId, userId, orderId);
            }
        }
    }
}

