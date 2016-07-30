package com.serviceLayer.implementation;

import com.dataLayer.entity.DTO.orderDTO.OrderPlacementStatus;
import com.dataLayer.entity.DTO.restaurantDTO.RestaurantDTO;
import com.dataLayer.DAO.Interfaces.RestaurantDAO;
import com.dataLayer.entity.base.*;
import com.serviceLayer.service.EventService;
import com.serviceLayer.service.OrderItemService;
import com.serviceLayer.service.OrderService;
import com.serviceLayer.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantDAO restaurantDAO;
    @Autowired
    OrderService orderService;
    @Autowired
    EventService eventService;
    @Autowired
    OrderItemService orderItemService;

    @Override
    public void save(Restaurant restaurant) {
        restaurantDAO.save(restaurant);
    }

    @Override
    public List<RestaurantDTO> getResponseListOfAllRestaurantsByEventId(int eventId, Authentication authentication) {
        List<RestaurantDTO> restaurants = new ArrayList<>();
        fillingRestaurantsList(eventId, authentication, restaurants);

        return restaurants;
    }

    private void fillingRestaurantsList(int eventId, Authentication authentication, List<RestaurantDTO> restaurants) {
        for (Restaurant restaurant : getListOfAllRestaurant()) {
            restaurants.add(getRestaurantDTOById(eventId, restaurant.getId(), authentication));
        }
    }

    @Override
    public List<Restaurant> getListOfAllRestaurant() {
        return restaurantDAO.getListOfAllRestaurant();
    }

    @Override
    public Restaurant getRestaurantById(int id) {
        return restaurantDAO.getRestaurantById(id);
    }

    @Override
    public RestaurantDTO getRestaurantDTOById(int eventId, int restaurantId, Authentication authentication) {
        Restaurant restaurant = restaurantDAO.getRestaurantById(restaurantId);
        List<Order> orders = orderService.getOrdersByEventIdAndRestaurantIdAndStatus(eventId, restaurantId, Status.PENDING);
        OrderPlacementStatus orderPlacementStatus = null;
        if (!orders.isEmpty()) {
            Order order = getOrderWhereUserMakeOrder(orders, (User) authentication.getPrincipal());
            orderPlacementStatus = orderService.getOrderPlacementStatus(order, authentication);
        }
        int pendingOrders = orders.stream().filter(p -> p.getStatus().equals(Status.PENDING)).collect(Collectors.toList()).size();
        return new RestaurantDTO(restaurant, orderPlacementStatus, pendingOrders);
    }

    private Order getOrderWhereUserMakeOrder(List<Order> orders, User user) {
        for (Order order : orders) {
            for (OrderItem orderItem : orderItemService.getOrderListByOrderId(order.getId())) {
                if (isSameUser(user, orderItem)) {
                    return orderItem.getOrder();
                }
            }
        }
        return orders.get(0);
    }

    private boolean isSameUser(User user, OrderItem orderItem) {
        return orderItem.getUser().getId() == user.getId();
    }
}


