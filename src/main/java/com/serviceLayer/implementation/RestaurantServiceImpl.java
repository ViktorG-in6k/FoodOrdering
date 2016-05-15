package com.serviceLayer.implementation;

import com.dataLayer.entity.DTO.orderDTO.OrderPlacementStatus;
import com.dataLayer.entity.DTO.restaurantDTO.RestaurantDTO;
import com.dataLayer.DAO.Interfaces.RestaurantDAO;
import com.dataLayer.entity.base.Order;
import com.dataLayer.entity.base.Restaurant;
import com.serviceLayer.service.EventService;
import com.serviceLayer.service.OrderService;
import com.serviceLayer.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantDAO restaurantDAO;
    @Autowired
    OrderService orderService;
    @Autowired
    EventService eventService;

    @Override
    public void save(Restaurant restaurant) {
        restaurantDAO.save(restaurant);
    }

    @Override
    public List<RestaurantDTO> getResponseListOfAllRestaurantsByEventId(int eventId, Authentication authentication) {
        List<RestaurantDTO> restaurants = new ArrayList<>();
        for (Restaurant restaurant : getListOfAllRestaurant()) {
            restaurants.add(getRestaurantDTOById(eventId, restaurant.getId(), authentication));
        }
        return restaurants;
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
        List<Order> orders = orderService.getOrdersByEventIdAndRestaurantId(eventId, restaurantId);
        OrderPlacementStatus orderPlacementStatus = null;
        if (orders.size() > 0) {
            orderPlacementStatus = orderService.getOrderPlacementStatus(orders.get(0), restaurantId, eventId, authentication);
        }
        return new RestaurantDTO(restaurant, orderPlacementStatus);
    }
}

