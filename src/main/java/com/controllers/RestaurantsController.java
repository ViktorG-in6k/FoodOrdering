package com.controllers;

import com.DTOLayer.DTOEntity.RequestRestaurantDTO;
import com.DTOLayer.DTOEntity.restaurantDTO.RestaurantDTO;
import com.serviceLayer.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RestaurantsController {
    @Autowired
    RestaurantService restaurantService;

    @RequestMapping(value = "/new_restaurant", method = RequestMethod.POST)
    public String newRestaurant(HttpServletRequest req, @RequestParam("eventId") int eventId) {
        restaurantService.saveByRequest(req);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref + "#/" + eventId;
    }

    @RequestMapping(value = "/events/event_{id}")
    public String getAllRestaurants(HttpSession session, @PathVariable("id") String id) {
        session.setAttribute("eventId", id);
        session.setAttribute("allRestaurants", restaurantService.getListOfAllRestaurant());
        session.setAttribute("backPage", "/events");
        return "eventDetails";
    }

    @RequestMapping(value = "/events/event_{event}/restaurant_{id}")
    public String getAllItemsByRestaurant(HttpSession session, @PathVariable("event") int event, @PathVariable("id") int id) {
        session.setAttribute("restaurant", restaurantService.getRestaurantById(id));
        session.setAttribute("Menu", restaurantService.getRestaurantById(id).getItem());
        session.setAttribute("backPage", "/events/event_" + event);
        return "menu";
    }

    @RequestMapping("/event_{event}/restaurants")
    public
    @ResponseBody
    List<RestaurantDTO> getRestaurants(HttpSession session,
                                       @PathVariable("event") int eventId) {
        return restaurantService.getResponseListOfAllRestaurantsByEventId(eventId,session);
    }

    @RequestMapping("/event_{event}/restaurant_{id}")
    public
    @ResponseBody
    RestaurantDTO getRestaurantById(HttpSession session,
                                    @PathVariable("event") int eventId,
                                    @PathVariable("id") int id) {
        return restaurantService.getRestaurantDTOById(eventId, id, session);
    }

    @RequestMapping(value = "/event_{event}/update_restaurant_name", method = RequestMethod.POST)
    public ResponseEntity<RestaurantDTO> updateRestaurantName(HttpSession session,
                                                              @PathVariable("event") int eventId,
                                                              @RequestBody RequestRestaurantDTO restaurant) {
        restaurantService.updateRestaurantName(restaurant);
        RestaurantDTO restaurantDTO = getRestaurantById(session,eventId,restaurant.getId());
        return new ResponseEntity<>(restaurantDTO, HttpStatus.OK);
    }
}

