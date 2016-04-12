package com.serviceLayer.service;

import com.model.Item;
import com.model.Restaurant;

import java.util.List;


public interface RestaurantService {
    public void save(Restaurant restaurant);
    public List<Restaurant> getListOfAllRestaurant();
    public Restaurant getRestaurantById(int id);
    public List<Item> getRestaurantMenuById(int id);
}
