package com.controllers;

import com.model.Entity.Restaurant;
import com.DTOLayer.DTOEntity.RestaurantDTO;
import com.serviceLayer.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewsResponseController {
    @Autowired
    RestaurantService restaurantService;

    @RequestMapping("/restaurants")
    public  @ResponseBody
    List<RestaurantDTO> get_restaurants() {

        List<RestaurantDTO> RestaurantDTOs = new ArrayList<RestaurantDTO>();
        for (Restaurant restaurant: restaurantService.getListOfAllRestaurant()) {
            RestaurantDTOs.add(new RestaurantDTO(restaurant));
        }
        return RestaurantDTOs;
    }
}
