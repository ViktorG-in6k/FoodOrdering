package com.dataLayer.DAO;

import com.model.Restaurant;

import java.util.List;

/**
 * Created by employee on 3/29/16.
 */
public interface RestaurantDAO {

    public void save(Restaurant restaurant);
    public List<Restaurant> getListOfAllRestaurant();
    public Restaurant getRestaurantByName(String restaurantName);


}