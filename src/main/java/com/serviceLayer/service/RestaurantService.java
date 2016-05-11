package com.serviceLayer.service;

import com.DTOLayer.DTOEntity.RequestRestaurantDTO;
import com.DTOLayer.DTOEntity.restaurantDTO.RestaurantDTO;
import com.model.Entity.Item;
import com.model.Entity.Restaurant;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface RestaurantService {
    public void save(Restaurant restaurant);

    public void saveByRequest(HttpServletRequest req);

    List<RestaurantDTO> getResponseListOfAllRestaurantsByEventId(int eventId, Authentication authentication);

    public List<Restaurant> getListOfAllRestaurant();

    public Restaurant getRestaurantById(int id);

    RestaurantDTO getRestaurantDTOById(int eventId, int restaurantId, Authentication authentication);

    public List<Item> getRestaurantMenuById(int id);

    void updateRestaurantName(RequestRestaurantDTO restaurant);

    void updateRestaurantDescription(RequestRestaurantDTO restaurant);
}

