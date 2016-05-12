package com.serviceLayer.implementation;

import com.dataLayer.entity.DTO.RequestRestaurantDTO;
import com.dataLayer.entity.DTO.orderDTO.OrderPlacementStatus;
import com.dataLayer.entity.DTO.restaurantDTO.RestaurantDTO;
import com.dataLayer.DAO.Interfaces.RestaurantDAO;
import com.dataLayer.entity.Item;
import com.dataLayer.entity.Order;
import com.dataLayer.entity.Restaurant;
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
    public void saveByRequest(HttpServletRequest req) {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String link = req.getParameter("link");
        Restaurant restaurant = new Restaurant(name, phone, link);
        restaurantDAO.save(restaurant);
    }

    @Override
    public List<RestaurantDTO> getResponseListOfAllRestaurantsByEventId(int eventId, Authentication authentication) {
        List<RestaurantDTO> restaurants = new ArrayList<RestaurantDTO>();
        Order order;
        for (Restaurant restaurant : getListOfAllRestaurant()) {
            order = orderService.getOrdersByEventIdAndRestaurantId(eventId, restaurant.getId());
            restaurants.add(new RestaurantDTO(restaurant, orderService.getOrderPlacementStatus(order, restaurant.getId(), eventId, authentication)));
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
        Order order = orderService.getOrdersByEventIdAndRestaurantId(eventId,restaurantId);
        Restaurant restaurant = restaurantDAO.getRestaurantById(restaurantId);
        OrderPlacementStatus orderPlacementStatus = orderService.getOrderPlacementStatus(order, restaurantId, eventId, authentication);
        return new RestaurantDTO(restaurant, orderPlacementStatus);
    }

    @Override
    public List<Item> getRestaurantMenuById(int id) {
        return restaurantDAO.getRestaurantMenuById(id);
    }

    @Override
    public void updateRestaurantName(RequestRestaurantDTO restaurant) {
        restaurantDAO.updateName(restaurant.getId(), restaurant.getName());
    }

    @Override
    public void updateRestaurantDescription(RequestRestaurantDTO restaurant) {
        restaurantDAO.updateDescription(restaurant.getId(), restaurant.getPhone());
    }
}

