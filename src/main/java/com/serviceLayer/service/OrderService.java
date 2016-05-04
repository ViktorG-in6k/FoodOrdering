package com.serviceLayer.service;

import com.DTOLayer.DTOEntity.orderDTO.OrderDTOList;
import com.DTOLayer.DTOEntity.orderDTO.OrderDTOListOfEachUser;
import com.model.Entity.Event;
import com.model.Entity.Item;
import com.model.Entity.Order;
import com.model.Entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface OrderService {
    public void save(Order order);

    public void saveByRequest(HttpServletRequest req, HttpSession session);

    public OrderDTOList orderListOfUserByEvent(int userId, int eventId);

    public void setResponsibleUser(int userId, int eventId, int restaurantId);

    public OrderDTOList orderListOfEvent(int eventId);

    OrderDTOList orderListOfUserByRestaurant(int eventId, int restaurantId);

    OrderDTOList orderListOfUserByRestaurantInEvent(int eventId, int restaurantId, int userId);

    public void deleteItemFromOrder(int userId, int eventId, int itemId);

    public void deleteOneItemFromOrder(int userId, int eventId, int itemId);

    public void updateOrderedOfOrder(boolean ordered, int eventId, int itemId);

    public List<OrderDTOListOfEachUser> orderDTOListOfEachUser(int eventId);

    void addNumberItemToOrder(User user, Item item, Event event, int number);

    void deleteNumberItemFromOrder(int userId, int eventId, int itemId, int number);

    void updateNumberItemToOrder(User user, Item item, Event event, int number);

    void addNumberItemFromOrder(int userId, int eventId, int itemId, int number);

    void addNumberItemFromOrder(Order order, int amount);
}

