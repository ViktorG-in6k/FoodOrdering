package com.serviceLayer.implementation;

import com.DTOLayer.DTOEntity.RequestRestaurantDTO;
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
        restaurantDAO.save(restaurant);
    }

    @Override
    public void saveByRequest(HttpServletRequest req) {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String link = req.getParameter("link");
        Restaurant restaurant = new Restaurant(name, phone, link);
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

    @Override
    public void updateRestaurantName(RequestRestaurantDTO restaurant) {
        restaurantDAO.updateName(restaurant.getId(), restaurant.getName());
    }

    @Override
    public void updateRestaurantDescription(RequestRestaurantDTO restaurant) {
        restaurantDAO.updateDescription(restaurant.getId(), restaurant.getPhone());
    }
}

