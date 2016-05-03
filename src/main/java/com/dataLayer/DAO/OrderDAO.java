package com.dataLayer.DAO;

import com.model.Entity.Order;

import java.util.List;

public interface OrderDAO {
    public void save(Order order);

    public List<Order> orderListOfUserByEvent(int userId, int eventId);

    public List<Order> orderListOfEvent(int eventId);

    public void deleteItemFromOrder(int userId, int eventId, int itemId);

    List<Order> selectOrderList(int userId, int eventId, int itemId);

    List<Order> selectOrderList(int userId, int eventId);

    void deleteOneItemFromOrder(int userId, int eventId, int itemId);

    void deleteOneItemFromOrder(Order order);

    public void updateOrderedOfOrder(boolean ordered, int eventId, int itemId);

    void setResponsibleUser(int userId, int eventId, int restaurantId);
}

