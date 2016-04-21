package com.serviceLayer.implementation;

import com.DTOLayer.DTOEntity.RestaurantDTO;
import com.dataLayer.DAO.RestaurantDAO;
import com.model.Entity.Item;
import com.model.Entity.Restaurant;
import com.serviceLayer.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    RestaurantDAO restaurantDAO;

    @Override
    public void save(Restaurant restaurant) {
        if (restaurant.getImageURL().equals("")) {
            restaurant.setImageURL("http://localhost:8080/resources/image/restaurant.jpg");
        }
        restaurantDAO.save(restaurant);
    }

    @Override
    public void saveByRequest(HttpServletRequest req) {
        String name = req.getParameter("name");
        String description = req.getParameter("discript");
        String URLimage = req.getParameter("image");
        Restaurant restaurant = new Restaurant(name, description, URLimage);
        if (restaurant.getImageURL().equals("")) {
            restaurant.setImageURL("/resources/image/restaurant.jpg");
        }
        restaurantDAO.save(restaurant);
    }

    @Override
    public List<Restaurant> getListOfAllRestaurant() {
        return restaurantDAO.getListOfAllRestaurant();
    }

    @Override
    public Restaurant getRestaurantById(int id) {
        return restaurantDAO.getRestaurantById(id);
    }

    @Override
    public RestaurantDTO getRestaurantDTOById(int id) {
        return new RestaurantDTO(restaurantDAO.getRestaurantById(id));
    }

    @Override
    public List<Item> getRestaurantMenuById(int id) {
        return restaurantDAO.getRestaurantMenuById(id);
    }
}

