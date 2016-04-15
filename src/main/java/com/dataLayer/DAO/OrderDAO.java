package com.dataLayer.DAO;

import com.model.Entity.Order;

import java.util.List;

public interface OrderDAO {
    public void save(Order order);
    public List<Order> orderListOfUserByEvent(int userId,int eventId);
    public List<Order> orderListOfEvent(int eventId);
}