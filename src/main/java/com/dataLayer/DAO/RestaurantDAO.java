package com.dataLayer.DAO;

import com.model.Restaurant;

import java.util.List;

public interface RestaurantDAO {

    public void save(Restaurant restaurant);
    public List<Restaurant> getListOfAllRestaurant();
    public Restaurant getRestaurantByName(String restaurantName);


}