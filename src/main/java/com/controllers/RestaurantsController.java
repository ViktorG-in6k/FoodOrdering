package com.controllers;

import com.dataLayer.entity.DTO.restaurantDTO.RestaurantDTO;
import com.dataLayer.entity.base.Restaurant;
import com.serviceLayer.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class RestaurantsController {
    @Autowired
    RestaurantService restaurantService;

    @RequestMapping(value = "api/restaurants", method = RequestMethod.POST)
    public String newRestaurant(@RequestParam("name") String name, @RequestParam("link") String link, @RequestParam("phone") String phone){
        restaurantService.save(new Restaurant(name, phone, link));
        return "{\"status\":\"200\"}";
    }

    @RequestMapping("/events/{eventId}/restaurants")
    public List<RestaurantDTO> getRestaurants(Authentication authentication,
                                       @PathVariable("eventId") int eventId) {
        return restaurantService.getResponseListOfAllRestaurantsByEventId(eventId, authentication);
    }

    @RequestMapping("/events/{eventId}/restaurants/{restaurantId}")
    public RestaurantDTO getRestaurantById(Authentication authentication,
                                    @PathVariable("eventId") int eventId,
                                    @PathVariable("restaurantId") int restaurantId) {
        return restaurantService.getRestaurantDTOById(eventId, restaurantId, authentication);
    }
}