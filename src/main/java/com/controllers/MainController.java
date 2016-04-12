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
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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



    @RequestMapping(value ="/my_order")
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

    @RequestMapping(value = "/events",method = RequestMethod.POST)
    public String events(HttpSession session, HttpServletRequest req) {
        session.setAttribute("userId", userService.getUserByEmail(req.getParameter("email")).getId());
        session.setAttribute("allEvents", eventService.getListOfAllEvents());
        session.setAttribute("backPage", "/events");

        return "events";
    }

    @RequestMapping(value = "/sing_out")
    public String sing_out(HttpSession session) {
        session.setAttribute("userMail", null);
        return "main";
    }

    @RequestMapping(value = "/new_item", method = RequestMethod.POST)
    public String new_item(HttpServletRequest req, HttpSession session) {

        String name = req.getParameter("name");
        String description = req.getParameter("discript");
        String URLimage = req.getParameter("image");
        BigDecimal price = new BigDecimal(req.getParameter("price"));

        Restaurant restaurant = (Restaurant) session.getAttribute("restaurant");

        Item item = new Item(restaurant, name, description, URLimage, price);

        menuService.save(item);

        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping(value = "/new_event", method = RequestMethod.POST)
    public String new_Event(HttpServletRequest req) {

        String name = req.getParameter("name");
        String description = req.getParameter("discript");
        String URLimage = req.getParameter("image");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime date = LocalDateTime.parse(req.getParameter("date"),formatter);

        Event event = new Event(name, description, URLimage, date);

        eventService.save(event);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping(value = "/new_restaurant", method = RequestMethod.POST)
    public String new_restaurant(HttpServletRequest req) {

        String name = req.getParameter("name");
        String description = req.getParameter("discript");
        String URLimage = req.getParameter("image");
        Restaurant restaurant = new Restaurant(name, description, URLimage);
        restaurantService.save(restaurant);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping(value = "/add_to_order", method = RequestMethod.POST)
    public String addToOrder(HttpServletRequest req, HttpSession session) {

        int item_id = Integer.parseInt(req.getParameter("item_id"));
        int event_id = Integer.parseInt(req.getParameter("event_id"));
        int user_id = (int) session.getAttribute("userId");

        Order order = new Order(item_id, event_id);
        EventUser eventUser = new EventUser(user_id,event_id);


        eventUserService.save(eventUser);
        orderService.save(order);

        User user = userService.getUser(user_id);
        for (Event e: user.getEventsList()) {
            System.out.println(e.getName());
        }

        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

//    @RequestMapping(value = "/add_to_order", method = RequestMethod.POST)
//    public ResponseEntity<EventResponse> Order(HttpServletRequest req, HttpSession session) {
//
//        int item_id = Integer.parseInt(req.getParameter("item_id"));
//        int event_id = Integer.parseInt(req.getParameter("event_id"));
//        int user_id = (int) session.getAttribute("userId");
//
//        Order order = new Order(item_id, event_id);
//        EventUser eventUser = new EventUser(user_id,event_id);
//
//
//        eventUserService.save(eventUser);
//        orderService.save(order);
//
//        User user = userService.getUser(user_id);
//
//        Set<EventResponse> set = eventUserService.setResp(user);
//
//
//        return "redirect:" + ref;
//    }

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
//
//
//    @RequestMapping(value = {"/qweq", "/welcome**"}, method = RequestMethod.GET)
//    public String defaultPage() {
//
//        ModelAndView model = new ModelAndView();
//        model.addObject("title", "Spring Security + Hibernate Example");
//        model.addObject("message", "This is default page!");
//        model.setViewName("hello");
//        return "hello";
//
//    }
//
//
//
//
//    private String getErrorMessage(HttpServletRequest request, String key) {
//
//        Exception exception = (Exception) request.getSession().getAttribute(key);
//
//        String error = "";
//        if (exception instanceof BadCredentialsException) {
//            error = "Invalid username and password!";
//        } else if (exception instanceof LockedException) {
//            error = exception.getMessage();
//        } else {
//            error = "Invalid username and password!";
//        }
//
//        return error;
//    }
//
//    // for 403 access denied page
//    @RequestMapping(value = "/403", method = RequestMethod.GET)
//    public ModelAndView accesssDenied() {
//
//        ModelAndView model = new ModelAndView();
//
//        // check if user is login
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (!(auth instanceof AnonymousAuthenticationToken)) {
//            UserDetails userDetail = (UserDetails) auth.getPrincipal();
//            System.out.println(userDetail);
//
//            model.addObject("username", userDetail.getUsername());
//
//        }
//
//        model.setViewName("403");
//        return model;
//
//    }

//    @RequestMapping(value = "/")
//    public String getMain(Model model) {
//        return "main";
//    }
//
//    @RequestMapping(value = "/events", method = RequestMethod.POST)
//    public String events(HttpServletRequest req, HttpSession session) {
//        String email = req.getParameter("email");
//        session.setAttribute("backPage","/");
//        userService.saveUser(email);
//
//        session.setAttribute("userMail", email);
//        session.setAttribute("allEvents", eventService.getListOfAllEvents());
//
//        return "events";
//    }
//
//    @RequestMapping(value = "/events")
//    public String events(HttpSession session) {
//        session.setAttribute("allEvents", eventService.getListOfAllEvents());
//        session.setAttribute("backPage","/events");
//
//        return "events";
//    }
//
//    @RequestMapping(value = "/sing_out")
//    public String sing_out(HttpSession session) {
//        session.setAttribute("userMail", null);
//        return "main";
//    }
//
//    @RequestMapping(value = "/new_item", method = RequestMethod.POST)
//    public String new_item(HttpServletRequest req,HttpSession session) {
//
//        String name = req.getParameter("name");
//        String description = req.getParameter("discript");
//        String URLimage = req.getParameter("image");
//        BigDecimal price = new BigDecimal(req.getParameter("price"));
//
//        Restaurant restaurant =(Restaurant)session.getAttribute("restaurant");
//
//        Item item = new Item(restaurant, name, description, URLimage, price);
//
//        menuService.save(item);
//
//        String ref = req.getHeader("Referer");
//        return "redirect:" + ref;
//    }
//
//    @RequestMapping(value = "/new_event", method = RequestMethod.POST)
//    public String new_Event(HttpServletRequest req) {
//
//        String name = req.getParameter("name");
//        String description = req.getParameter("discript");
//        String URLimage = req.getParameter("image");
//        LocalDateTime date = LocalDateTime.parse(req.getParameter("date"));
//
//        Event event = new Event(name, description, URLimage, date);
//
//        eventService.save(event);
//        String ref = req.getHeader("Referer");
//        return "redirect:" + ref;
//    }
//
//    @RequestMapping(value = "/new_restaurant", method = RequestMethod.POST)
//    public String new_restaurant(HttpServletRequest req) {
//
//        String name = req.getParameter("name");
//        String description = req.getParameter("discript");
//        String URLimage = req.getParameter("image");
//        Restaurant restaurant = new Restaurant(name, description, URLimage);
//        restaurantService.save(restaurant);
//        String ref = req.getHeader("Referer");
//        return "redirect:" + ref;
//    }
//
//    @RequestMapping(value = "/add_to_order", method = RequestMethod.POST)
//    public String addToOrder(HttpServletRequest req, HttpSession session) {
//
//        int item_id = Integer.parseInt(req.getParameter("item_id"));
//        int event_id = Integer.parseInt(req.getParameter("event_id"));
//
//        Order order = new Order(item_id,event_id);
//
//        orderService.save(order);
//        String ref = req.getHeader("Referer");
//        return "redirect:" + ref;
//    }
//
//    @RequestMapping(value = "/events/event_{id}")
//    public String get_restaurants(HttpSession session, @PathVariable("id") String id) {
//        session.setAttribute("eventId", id);
//        session.setAttribute("allRestaurants", restaurantService.getListOfAllRestaurant());
//        session.setAttribute("backPage","/events");
//        return "restaurants";
//    }
//
//    @RequestMapping(value = "/events/event_{event}/restaurant_{id}")
//    public String get_menu(HttpSession session,@PathVariable("event") int event, @PathVariable("id") int id) {
//        session.setAttribute("restaurant",restaurantService.getRestaurantById(id));
//        session.setAttribute("Item", restaurantService.getRestaurantById(id).getItem());
//        session.setAttribute("backPage","/events/event_"+event);
//        return "menu";
//    }
}


