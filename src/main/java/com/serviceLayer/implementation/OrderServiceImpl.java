package com.serviceLayer.implementation;

import com.dataLayer.entity.DTO.orderDTO.OrderPlacementStatus;
import com.dataLayer.entity.DTO.orderItemDTO.OrderItemDTO;
import com.dataLayer.entity.DTO.orderItemDTO.OrderItemRequest;
import com.dataLayer.DAO.Interfaces.OrderDAO;
import com.dataLayer.entity.*;
import com.serviceLayer.googleAuthentication.CurrentUserDetails;
import com.serviceLayer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDAO orderDAO;
    @Autowired
    UserService userService;
    @Autowired
    OrderItemService orderItemService;
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
    public void setPayerById(int orderId, int payerId) {
        orderDAO.setPayer(orderId,payerId);
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
            List<OrderItemDTO> orderItems = orderItemService.getOrderListByOrderId(order.getId());

                for(OrderItemDTO itemDTO : orderItems) {

                        participants.add(userService.getUser(itemDTO.getUser().getId()));

                }

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

