package com.controllers;

import com.Classes.AllList;
import com.Classes.OrderList;
import com.model.*;
import com.serviceLayer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    @Autowired
    EventUserService eventUserService;
    @Autowired
    UserDetailsService userDetailsService;

    @RequestMapping(value = "/partials/{part}")
    public String getPartialPage(@PathVariable("part") String part) {
        return "partials/" + part;
    }

    @RequestMapping("/eventsJson/")
    public  @ResponseBody
    Set<Event> getEvent() {
        Set<Event> events = eventService.getListOfAllEvents();
        return events;
    }

    @RequestMapping(value = "/my_order")
    @ResponseBody
    Set<EventResponse> response(HttpSession session) {
        int user_id = (int) session.getAttribute("userId");
        User user = userService.getUser(user_id);
        return eventUserService.getAllEvents(user);
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
        session.setAttribute("userId", userService.getUserByEmail(req.getParameter("email")).getId());
        return "events";
    }

    @RequestMapping(value = "/sing_out")
    public String sing_out(HttpSession session) {
        session.setAttribute("userMail", null);
        return "main";
    }

    @RequestMapping(value = "/new_item", method = RequestMethod.POST)
    public String new_item(HttpServletRequest req, HttpSession session) {
        menuService.saveByRequest(req, session);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping(value = "/new_event", method = RequestMethod.POST)
    public String new_Event(HttpServletRequest req) {
        eventService.saveByRequest(req);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping(value = "/new_restaurant", method = RequestMethod.POST)
    public String new_restaurant(HttpServletRequest req) {
        restaurantService.saveByRequest(req);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping(value = "/add_to_order", method = RequestMethod.POST)
    public String addToOrder(HttpServletRequest req, HttpSession session) {
        orderService.saveByRequest(req, session);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping(value = "/events/event_{id}")
    public String get_restaurants(HttpSession session, @PathVariable("id") String id) {
        session.setAttribute("eventId", id);
        session.setAttribute("allRestaurants", restaurantService.getListOfAllRestaurant());
        session.setAttribute("backPage", "/events");
        return "restaurants";
    }

    @RequestMapping(value = "/events/event_{event}/restaurant_{id}")
    public String get_menu(HttpSession session, @PathVariable("event") int event, @PathVariable("id") int id) {
        session.setAttribute("restaurant", restaurantService.getRestaurantById(id));
        session.setAttribute("Menu", restaurantService.getRestaurantById(id).getItem());
        session.setAttribute("backPage", "/events/event_" + event);
        return "menu";
    }

    @RequestMapping(value = "/events/event_{event}/order_list")
    public String get_order(HttpSession session, @PathVariable("event") int event) {
        OrderList orderList = new OrderList(eventService.getEventById(event).getItemsList());
        List<AllList> allList = new ArrayList<AllList>();
        for (Restaurant rest : restaurantService.getListOfAllRestaurant()) {
            allList.add(new AllList(rest, new OrderList(eventService.getEventById(event).getItemsList())));
        }
        List<AllList> orderL = new ArrayList<AllList>();
        for (AllList l : allList) {
            if (l.getOrderList().size() != 0) {
                orderL.add(l);
            }
        }
        session.setAttribute("orderList", orderL);
        session.setAttribute("backPage", "/events/event_" + event);
        return "order";
    }
}
