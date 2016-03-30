package com.controllers;

import com.model.Event;
import com.model.User;
import com.serviceLayer.service.EventService;
import com.serviceLayer.service.RestaurantService;
import com.serviceLayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
public class MainController {

    @Autowired
    UserService userService;
    @Autowired
    EventService eventService;
    @Autowired
    RestaurantService restaurantService;

    @RequestMapping(value = "/")
    public String getMain(Model model) {
        return "hello";
    }

    @RequestMapping(value = "/sing_in")
    public String sing_in(HttpServletRequest req, HttpSession session) {
        String email = req.getParameter("email");
        User person = new User("User", email);

        if (userService.getUserByEmail(email) == null) {
            userService.saveUser(person);
        }

        session.setAttribute("userMail", email);
        session.setAttribute("allEvents", eventService.getListOfAllEvents());
        return "main";
    }


    @RequestMapping(value = "/sing_out")
    public String sing_out(HttpSession session) {
        session.setAttribute("userMail", null);
        return "hello";
    }

    @RequestMapping(value = "/new_event", method = RequestMethod.POST)
    public String new_Event(HttpServletRequest req, HttpSession session) {

        String name = req.getParameter("name");
        String description = req.getParameter("discript");
        String URLimage = req.getParameter("image");
        LocalDateTime date = LocalDateTime.parse(req.getParameter("date"));
        Event event = new Event(name, description, URLimage, date);
        eventService.save(event);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping(value = "/events/*")
    public String get_restaurants(HttpSession session) {

        session.setAttribute("allRestaurants", restaurantService.getListOfAllRestaurant());
        return "restaurants";
    }
}
