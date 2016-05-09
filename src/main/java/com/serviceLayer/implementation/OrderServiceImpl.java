package com.serviceLayer.implementation;

import com.DTOLayer.DTOEntity.orderDTO.OrderPlacementStatus;
import com.DTOLayer.DTOEntity.orderItemDTO.OrderItemRequest;
import com.dataLayer.DAO.OrderDAO;
import com.model.Entity.*;
import com.serviceLayer.service.ItemService;
import com.serviceLayer.service.OrderService;
import com.serviceLayer.service.StatusService;
import com.serviceLayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDAO orderDAO;
    @Autowired
    UserService userService;
    @Autowired
    ItemService itemService;
    @Autowired
    StatusService statusService;

    @Override
    public void save(Order order) {
        orderDAO.saveOrder(order);
    }

    @Override
    public void save(OrderItemRequest itemRequest, HttpSession session) {
        User user = userService.getUser((int) session.getAttribute("userId"));
        Item item = itemService.getItemById(itemRequest.getItem().getId());
        orderDAO.saveOrder(new Order());
    }

    @Override
    public Order getOrderByEvent(Event event) {
        return orderDAO.getOrderByEventId(event.getId());
    }

    @Override
    public Order getOrderById(int orderId) {
        return orderDAO.getOrderByOrderId(orderId);
    }

    @Override
    public OrderPlacementStatus getOrderPlacementStatus(Order order, HttpSession session) {
        Set<User> participants = new HashSet<>();
        boolean isMine = false;
        if (order != null) {
            order.getOrderItems().forEach(item -> participants.add(item.getUser()));
            isMine = isMineOrder(order, session);
            int participantsAmount = participants.size();
            return new OrderPlacementStatus(order, participantsAmount, isMine);
        }
        else return null;
    }

    @Override
    public boolean isMineOrder(Order order, HttpSession session) {
        int currentUserId = (int) session.getAttribute("userId");
        boolean isMine = false;

        for (OrderItem item : order.getOrderItems()) {
            if (item.getUser().getId() == currentUserId) {
                isMine = true;
                break;
            }
        }
        return isMine;
    }
}

