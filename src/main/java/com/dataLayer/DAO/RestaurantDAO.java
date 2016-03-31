package com.dataLayer.DAO;

import com.model.Menu;
import com.model.Restaurant;

import java.util.List;

public interface RestaurantDAO {

    public void save(Restaurant restaurant);
    public List<Restaurant> getListOfAllRestaurant();
    public Restaurant getRestaurantByName(String restaurantName);
    public Restaurant getRestaurantById(int id);
    public List<Menu> getRestaurantMenuById(int id);

}