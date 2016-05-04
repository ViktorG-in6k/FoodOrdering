package com.dataLayer.DAO;

import com.model.Entity.Event;
import com.model.Entity.Item;
import com.model.Entity.Order;
import com.model.Entity.User;

import java.util.List;

public interface OrderDAO {
    public void save(Order order);

    void updateAmount(Order order, int amount);

    void updateAmount(Order order);

    List<Order> getUserResponsibilityOrderList(Order order);

    public List<Order> orderListOfUserByEvent(int userId, int eventId);

    public List<Order> orderListOfEvent(int eventId);

    public void deleteItemFromOrder(int userId, int eventId, int itemId);

    List<Order> selectOrderList(int userId, int eventId, int itemId);

    List<Order> selectOrderList(int userId, int eventId);

    void deleteOneItemFromOrder(int userId, int eventId, int itemId);

    void deleteOneItemFromOrder(Order order);

    public void updateOrderedOfOrder(boolean ordered, int eventId, int itemId);

    void setResponsibleUser(int userId, int eventId, int restaurantId);

    void saveNumberItemToOrder(User user, Item item, Event event, int number);

    void deleteNumberItemFromOrder(int userId, int eventId, int itemId, int number);
}

