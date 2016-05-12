package com.controllers;

import com.DTOLayer.DTOEntity.restaurantDTO.RestaurantDTO;
import com.serviceLayer.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class RestaurantsController {
    @Autowired
    RestaurantService restaurantService;

    @RequestMapping(value = "/restaurants", method = RequestMethod.POST)
    public String newRestaurant(HttpServletRequest req, @RequestParam("name") String name, @RequestParam("eventId") int eventId) throws UnsupportedEncodingException {
        restaurantService.saveByRequest(req);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref + "#/" + eventId;
    }

    @RequestMapping("/events/{eventId}/restaurants")
    public
    @ResponseBody
    List<RestaurantDTO> getRestaurants(Authentication authentication,
                                       @PathVariable("eventId") int eventId) {
        return restaurantService.getResponseListOfAllRestaurantsByEventId(eventId, authentication);
    }

    @RequestMapping("/events/{eventId}/restaurants/{restaurantId}")
    public
    @ResponseBody
    RestaurantDTO getRestaurantById(Authentication authentication,
                                    @PathVariable("eventId") int eventId,
                                    @PathVariable("restaurantId") int restaurantId) {
        return restaurantService.getRestaurantDTOById(eventId, restaurantId, authentication);
    }
}

