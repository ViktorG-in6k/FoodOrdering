package com.serviceLayer.implementation;

import com.dataLayer.DAO.OrderDAO;
import com.model.Entity.Event;
import com.model.Entity.Item;
import com.model.Entity.Order;
import com.model.Entity.User;
import com.serviceLayer.service.EventService;
import com.serviceLayer.service.MenuService;
import com.serviceLayer.service.OrderService;
import com.serviceLayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDAO orderDAO;
    @Autowired
    MenuService menuService;
    @Autowired
    UserService userService;

    @Autowired
    EventService eventService;

    public void save(Order order) {
        orderDAO.save(order);
    }

    public void saveByRequest(HttpServletRequest req, HttpSession session) {
        int event_id = Integer.parseInt(req.getParameter("event_id"));
        Event event = eventService.getEventById(event_id);
        int item_id = Integer.parseInt(req.getParameter("item_id"));
        Item item = menuService.getItemById(item_id);
        int user_id = (int) session.getAttribute("userId");
        User user = userService.getUser(user_id);

        Order order = new Order(user,item,event);

        orderDAO.save(order);
    }

    @Override
    public List<Order> orderListOfUserByEvent(int userId, int eventId) {
        return orderDAO.orderListOfUserByEvent(userId,eventId);
    }

    @Override
    public List<Order> orderListOfEvent(int eventId) {
        return orderDAO.orderListOfEvent(eventId);
    }

    @Override
    public void deleteItemFromOrder(int userId, int eventId, int itemId) {
        orderDAO.deleteItemFromOrder(userId, eventId, itemId);
    }

    @Override
    public void deleteOneItemFromOrder(int userId, int eventId, int itemId) {
        orderDAO.deleteOneItemFromOrder( userId,  eventId,  itemId);
    }

    @Override
    public void updateOrderedOfOrder(boolean ordered, int eventId, int itemId) {
        orderDAO.updateOrderedOfOrder(ordered,eventId,itemId);
    }
}
