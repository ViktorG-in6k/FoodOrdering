package com.serviceLayer.service;

import com.DTOLayer.DTOEntity.RestaurantDTO;
import com.model.Entity.Item;
import com.model.Entity.Restaurant;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface RestaurantService {
    public void save(Restaurant restaurant);

    public void saveByRequest(HttpServletRequest req);

    public List<Restaurant> getListOfAllRestaurant();

    public Restaurant getRestaurantById(int id);

    RestaurantDTO getRestaurantDTOById(int id);

    public List<Item> getRestaurantMenuById(int id);

    void updateRestaurantName(RestaurantDTO restaurant);
}

