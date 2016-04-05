package com.controllers;

import com.Classes.AllList;
import com.Classes.DataForOrder;
import com.Classes.OrderList;
import com.model.Event;
import com.model.Menu;
import com.model.Order;
import com.model.Restaurant;
import com.serviceLayer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "/")
    public String getMain(Model model) {
        return "main";
    }

    @RequestMapping(value = "/test")
    public String getTest(Model model) {
        return "test";
    }

    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public String events(HttpServletRequest req, HttpSession session) {
        String email = req.getParameter("email");
        session.setAttribute("backPage","/");
        userService.saveUser(email);

        session.setAttribute("userMail", email);
        session.setAttribute("allEvents", eventService.getListOfAllEvents());

        return "events";
    }

    @RequestMapping(value = "/events")
    public String events(HttpSession session) {
        session.setAttribute("allEvents", eventService.getListOfAllEvents());
        session.setAttribute("backPage","/events");

        return "events";
    }

    @RequestMapping(value = "/sing_out")
    public String sing_out(HttpSession session) {
        session.setAttribute("userMail", null);
        return "main";
    }

    @RequestMapping(value = "/new_item", method = RequestMethod.POST)
    public String new_item(HttpServletRequest req,HttpSession session) {

        String name = req.getParameter("name");
        String description = req.getParameter("discript");
        String URLimage = req.getParameter("image");
        BigDecimal price = new BigDecimal(req.getParameter("price"));

        Restaurant restaurant =(Restaurant)session.getAttribute("restaurant");

        Menu item = new Menu(restaurant, name, description, URLimage, price);

        menuService.save(item);

        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping(value = "/new_event", method = RequestMethod.POST)
    public String new_Event(HttpServletRequest req) {

        String name = req.getParameter("name");
        String description = req.getParameter("discript");
        String URLimage = req.getParameter("image");
        LocalDateTime date = LocalDateTime.parse(req.getParameter("date"));

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

        Order order = new Order(item_id,event_id);

        orderService.save(order);
        String ref = req.getHeader("Referer");
        return "redirect:" + ref;
    }

    @RequestMapping(value = "/events/event_{id}")
    public String get_restaurants(HttpSession session, @PathVariable("id") String id) {
        session.setAttribute("eventId", id);
        session.setAttribute("allRestaurants", restaurantService.getListOfAllRestaurant());
        session.setAttribute("backPage","/events");
        return "restaurants";
    }

    @RequestMapping(value = "/events/event_{event}/restaurant_{id}")
    public String get_menu(HttpSession session,@PathVariable("event") int event, @PathVariable("id") int id) {
        session.setAttribute("restaurant",restaurantService.getRestaurantById(id));
        session.setAttribute("Menu", restaurantService.getRestaurantById(id).getMenu());
        session.setAttribute("backPage","/events/event_"+event);
        return "menu";
    }

    @RequestMapping(value = "/events/event_{event}/order_list")
    public String get_order(HttpSession session,@PathVariable("event") int event) {
        OrderList orderList = new OrderList(eventService.getEventById(event).getItemsList());
        List<AllList> allList = new ArrayList<AllList>();
        for (Restaurant rest: restaurantService.getListOfAllRestaurant()) {
            allList.add(new AllList(rest, new OrderList(eventService.getEventById(event).getItemsList())));
        }
//        List<DataForOrder> orderList = order(eventService.getEventById(event).getItemsList());
//        restaurantService.getListOfAllRestaurant();
//
//        for (DataForOrder data: orderList) {
//            System.out.print(data.getItem().getName());
//            System.out.print(" "+data.getItem().getPrice());
//            System.out.print(" "+data.getCount()+" ");
//            System.out.println(data.getCost());
//        }
        List<AllList>orderL = new ArrayList<AllList>();
        for (AllList l: allList) {
            if(l.getOrderList().size()!=0){
                orderL.add(l);
            }
        }
        session.setAttribute("orderList", orderL);
        session.setAttribute("backPage","/events/event_"+event);
        return "order";
    }

//    public List<DataForOrder> order(List<Menu> orders){
//        List<DataForOrder> orderList = new ArrayList<DataForOrder>();
//        boolean cond;
//        for (Menu item: orders) {
//            cond = false;
//            for (DataForOrder data: orderList) {
//                if(item==data.getItem()){
//                    data.setCount(data.getCount()+1);
//                    data.setCost(data.getCost().add(data.getItem().getPrice()));
//                    cond=true;
//                    break;
//                }
//            }
//            if(!cond){
//                orderList.add(new DataForOrder(item,1));
//            }
//        }
//        return orderList;
//    }
}
