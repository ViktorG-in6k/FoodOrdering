package com.serviceLayer.service;

import com.dataLayer.entity.DTO.restaurantDTO.RestaurantDTO;
import com.dataLayer.entity.base.Restaurant;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface RestaurantService {
    public void save(Restaurant restaurant);

    public void saveByRequest(HttpServletRequest req);

    List<RestaurantDTO> getResponseListOfAllRestaurantsByEventId(int eventId, Authentication authentication);

    public List<Restaurant> getListOfAllRestaurant();

    public Restaurant getRestaurantById(int id);

    RestaurantDTO getRestaurantDTOById(int eventId, int restaurantId, Authentication authentication);
}

