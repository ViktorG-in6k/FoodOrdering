package com.controllers;

import com.serviceLayer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    @Autowired
    UserService userService;
    @Autowired
    EventService eventService;
    @Autowired
    RestaurantService restaurantService;
    @Autowired
    MenuService menuService;
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/partials/{part}")
    public String getPartialPage(@PathVariable("part") String part) {
        return "partials/" + part;
    }

    @RequestMapping(value = "/")
    public String getMain() {
        return "main";
    }

    @RequestMapping(value = "/test")
    public String getTest(Model model) {
        return "test";
    }

    @RequestMapping(value = "/events")
    public String events(HttpSession session) {

        session.setAttribute("allEvents", eventService.getListOfAllEvents());
        session.setAttribute("backPage", "/events");
        return "events";
    }

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public String events(HttpSession session, HttpServletRequest req) {
        String email = req.getParameter("email");
        session.setAttribute("backPage","/");
        userService.saveUser(email);


        session.setAttribute("userId", userService.getUserByEmail(req.getParameter("email")).getId());
        return "events";
    }

    @RequestMapping(value = "/sing_out")
    public String singOut(HttpSession session) {
        session.setAttribute("userMail", null);
        return "main";
    }

    @RequestMapping(value = "/new_item", method = RequestMethod.POST)
    public String newItem(HttpServletRequest req, HttpSession session) {
        menuService.saveByRequest(req, session);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping(value = "/new_event", method = RequestMethod.POST)
    public String newEvent(HttpServletRequest req) {
        eventService.saveByRequest(req);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping(value = "/new_restaurant", method = RequestMethod.POST)
    public String newRestaurant(HttpServletRequest req , @RequestParam("eventId") int eventId) {
        restaurantService.saveByRequest(req);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref+"#/"+eventId;
    }

    @RequestMapping(value = "/add_to_order", method = RequestMethod.POST)
    public String addToOrder(HttpServletRequest req, HttpSession session) {
        orderService.saveByRequest(req, session);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping(value = "/events/event_{id}")
    public String getAllRestaurants(HttpSession session, @PathVariable("id") String id) {
        session.setAttribute("eventId", id);
        session.setAttribute("allRestaurants", restaurantService.getListOfAllRestaurant());
        session.setAttribute("backPage", "/events");
        return "restaurants";
    }

    @RequestMapping(value = "/events/event_{event}/restaurant_{id}")
    public String getAllItemsByRestaurant(HttpSession session, @PathVariable("event") int event, @PathVariable("id") int id) {
        session.setAttribute("restaurant", restaurantService.getRestaurantById(id));
        session.setAttribute("Menu", restaurantService.getRestaurantById(id).getItem());
        session.setAttribute("backPage", "/events/event_" + event);
        return "menu";
    }
}

