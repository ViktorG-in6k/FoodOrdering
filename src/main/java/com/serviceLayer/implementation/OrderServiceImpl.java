package com.serviceLayer.implementation;

import com.dataLayer.DAO.OrderDAO;
import com.model.EventUser;
import com.model.Order;
import com.serviceLayer.service.EventUserService;
import com.serviceLayer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDAO orderDAO;

    @Autowired
    EventUserService eventUserService;

    public void save(Order order) {
        orderDAO.save(order);
    }

    public void saveByRequest(HttpServletRequest req, HttpSession session) {
        int item_id = Integer.parseInt(req.getParameter("item_id"));
        int event_id = Integer.parseInt(req.getParameter("event_id"));
        int user_id = (int) session.getAttribute("userId");
        Order order = new Order(item_id, event_id);

        EventUser eventUserById = eventUserService.getEventUserById(user_id, event_id);
        if (eventUserById == null) {
            EventUser eventUser = new EventUser(user_id, event_id);
            eventUserService.save(eventUser);
        }

        orderDAO.save(order);
    }
}
