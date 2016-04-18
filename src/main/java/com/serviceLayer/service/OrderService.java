package com.serviceLayer.service;

import com.model.Entity.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface OrderService {
    public void save(Order order);

    public void saveByRequest(HttpServletRequest req, HttpSession session);

    public List<Order> orderListOfUserByEvent(int userId, int eventId);

    public List<Order> orderListOfEvent(int eventId);

    public void deleteItemFromOrder(int userId,int eventId,int itemId);

    public void deleteOneItemFromOrder(int userId, int eventId, int itemId);

//    void deleteOneItemFromOrder(Order order);

//    Order SelectOrder(int userId, int eventId, int itemId);

    public void updateOrderedOfOrder(boolean ordered, int eventId, int itemId);
}
