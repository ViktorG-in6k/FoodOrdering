package com.serviceLayer.implementation;

import com.DTOLayer.DTOEntity.orderItemDTO.OrderItemDTO;
import com.dataLayer.DAO.OrderItemDAO;
import com.googleAuthentication.CurrentUserDetails;
import com.model.Entity.*;
import com.serviceLayer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
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
    public void addOneItemToOrder(HttpSession session, int itemId, int orderId) {
        int userId = (int) session.getAttribute("userId");
        OrderItem orderInOrderList = orderItemDAO.getOrderItem(userId, itemId, orderId);
        if (orderInOrderList != null) {
            System.out.println(orderInOrderList.getItemAmount() + 1);
            orderItemDAO.updateAmount(orderInOrderList, orderInOrderList.getItemAmount() + 1);
        } else {
            saveOrderItem(itemId, userId, orderId);
        }
    }

    @Override
    public List<OrderItemDTO> getOrderListByOrderIdAndUserId(int orderId, int userId) {
        List<OrderItem> orderItems = orderItemDAO.getOrderListByOrderIdAndUserId(orderId, userId);
        List<OrderItemDTO> orderItemsDTO = new ArrayList<>();
        orderItems.forEach(orderItem -> orderItemsDTO.add(new OrderItemDTO(orderItem)));
        return orderItemsDTO;
    }

    @Override
    public void updateItemAmountInOrder(Authentication authentication, int orderId, int itemId, int number) {
        int userId =  ((CurrentUserDetails) authentication.getPrincipal()).getUser().getId();
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

