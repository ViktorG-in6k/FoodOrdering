package com.serviceLayer.service;

import com.model.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface OrderService {
    public void save(Order order);

    public void saveByRequest(HttpServletRequest req, HttpSession session);

    public List<Order> orderListOfUserByEvent(int userId, int eventId);

    public List<Order> orderListOfEvent(int eventId);
}
