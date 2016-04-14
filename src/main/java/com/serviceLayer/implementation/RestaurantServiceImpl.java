package com.serviceLayer.implementation;

import com.dataLayer.DAO.RestaurantDAO;
import com.model.Item;
import com.model.Restaurant;
import com.serviceLayer.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantDAO restaurantDAO;

    public void save(Restaurant restaurant) {
        if (restaurant.getImageURL().equals("")) {
            restaurant.setImageURL("/resources/image/restaurant.jpg");
        }
        restaurantDAO.save(restaurant);
    }

    public void saveByRequest(HttpServletRequest req) {
        String name = req.getParameter("name");
        String description = req.getParameter("discript");
        String URLimage = req.getParameter("image");
        Restaurant restaurant = new Restaurant(name, description, URLimage);
        restaurantDAO.save(restaurant);
    }

    public List<Restaurant> getListOfAllRestaurant() {
        return restaurantDAO.getListOfAllRestaurant();
    }

    public Restaurant getRestaurantById(int id) {
        return restaurantDAO.getRestaurantById(id);
    }

    public List<Item> getRestaurantMenuById(int id) {
        return restaurantDAO.getRestaurantMenuById(id);
    }
}
