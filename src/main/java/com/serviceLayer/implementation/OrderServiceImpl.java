package com.serviceLayer.implementation;

import com.DTOLayer.DTOEntity.orderDTO.OrderPlacementStatus;
import com.DTOLayer.DTOEntity.orderItemDTO.OrderItemRequest;
import com.dataLayer.DAO.OrderDAO;
import com.googleAuthentication.CurrentUserDetails;
import com.model.Entity.*;
import com.serviceLayer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    EventService eventService;
    @Autowired
    ItemService itemService;
    @Autowired
    StatusService statusService;
    @Autowired
    RestaurantService restaurantService;

    @Override
    public void save(Order order) {
        orderDAO.saveOrder(order);
    }

    @Override
    public void save(OrderItemRequest itemRequest) {
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

    @Transactional
    @Override
    public OrderPlacementStatus getOrderPlacementStatus(Order order,int restaurantId,int eventId, Authentication authentication) {
        Set<User> participants = new HashSet<>();
        boolean isMine;
        if (order != null) {
            order.getOrderItems().forEach(item -> participants.add(item.getUser()));
            isMine = isMineOrder(order, authentication);
            int participantsAmount = participants.size();
            return new OrderPlacementStatus(order, participantsAmount, isMine);
        }
        else{
            Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
            Event event = eventService.getEventById(eventId);
            Status status = statusService.getStatusById(0);
            Order order1 = new Order(restaurant,event,status);
            orderDAO.saveOrder(order1);
            return new OrderPlacementStatus(order1,0,false);
        }
    }

    @Override
    public Order getOrdersByEventIdAndRestaurantId(int eventId, int restaurantId){
        return orderDAO.getOrdersByEventIdAndRestaurantId(eventId, restaurantId);
    }

    @Override
    public boolean isMineOrder(Order order, Authentication authentication) {
        int currentUserId = ((CurrentUserDetails) authentication.getPrincipal()).getUser().getId();
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

