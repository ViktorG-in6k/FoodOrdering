package com.dataLayer.DAO;

import com.model.Order;

import java.util.List;

public interface OrderDAO {
    public void save(Order order);

    public List<Order> orderListOfUserByEvent(int userId,int eventId);
}