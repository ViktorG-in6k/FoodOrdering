package com.serviceLayer.implementation;

import com.dataLayer.DAO.RestaurantDAO;
import com.model.Restaurant;
import com.serviceLayer.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by employee on 3/30/16.
 */
@Service
public class RestaurantServiceImpl implements RestaurantService{
    @Autowired
    RestaurantDAO restaurantDAO;
    public void save(Restaurant restaurant) {
        restaurantDAO.save(restaurant);
    }

    public List<Restaurant> getListOfAllRestaurant() {
        return restaurantDAO.getListOfAllRestaurant();
    }
}
