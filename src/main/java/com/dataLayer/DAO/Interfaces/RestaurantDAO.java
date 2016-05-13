package com.dataLayer.DAO.Interfaces;

import com.dataLayer.entity.base.Item;
import com.dataLayer.entity.base.Restaurant;

import java.util.List;

public interface RestaurantDAO {
    public void save(Restaurant restaurant);

    public List<Restaurant> getListOfAllRestaurant();

    public Restaurant getRestaurantByName(String restaurantName);

    public Restaurant getRestaurantById(int id);

    public List<Item> getRestaurantMenuById(int id);

    void updateName(int id, String name);

    void updateDescription(int id, String description);
}

