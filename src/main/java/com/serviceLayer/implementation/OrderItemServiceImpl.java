package com.serviceLayer.implementation;

import com.dataLayer.DAO.OrderItemDAO;
import com.model.Entity.*;
import com.serviceLayer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

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
    public void saveOrderItem(int itemId, int userId) {
        Item item = itemService.getItemById(itemId);
        User user = userService.getUser(userId);
        saveOrderItem(new OrderItem(user, item));
    }

    @Override
    public void addOneItemToOrder(HttpSession session, int itemId, int orderId) {
        int userId = (int) session.getAttribute("userId");
        int number = orderItemDAO.getOrderItem(userId, itemId, orderId).getItemAmount() + 1;
        changeItemAmount(userId, itemId, orderId, number);
    }

    @Override
    public void updateItemAmountInOrder(HttpSession session, int orderId, int itemId, int number) {
        int userId = (int) session.getAttribute("userId");
        changeItemAmount(userId, itemId, orderId, number);
    }

    private void changeItemAmount(int userId, int itemId,int orderId,int number){
        OrderItem orderInOrderList = orderItemDAO.getOrderItem(userId, itemId, orderId);
        if (orderInOrderList != null) {
            orderItemDAO.updateAmount(orderInOrderList, number);
        } else {
            saveOrderItem(itemId, userId);
        }
    }
}

