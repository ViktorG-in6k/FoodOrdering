package com.serviceLayer.implementation;

import com.DTOLayer.DTOEntity.orderDTO.OrderDTOList;
import com.DTOLayer.DTOEntity.orderDTO.OrderDTOListOfEachUser;
import com.dataLayer.DAO.OrderDAO;
import com.model.Entity.Event;
import com.model.Entity.Item;
import com.model.Entity.Order;
import com.model.Entity.User;
import com.serviceLayer.service.EventService;
import com.serviceLayer.service.ItemService;
import com.serviceLayer.service.OrderService;
import com.serviceLayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDAO orderDAO;
    @Autowired
    ItemService itemService;
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
        Item item = itemService.getItemById(item_id);
        int user_id = (int) session.getAttribute("userId");
        User user = userService.getUser(user_id);

        Order order = new Order(user,item,event);

        orderDAO.save(order);
    }

    @Override
    public OrderDTOList orderListOfUserByEvent(int userId, int eventId) {
        return new OrderDTOList(orderDAO.orderListOfUserByEvent(userId,eventId));
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

    public List<OrderDTOListOfEachUser> orderDTOListOfEachUser(int eventId){
        List<User>users=userService.getListOfAllUsers();
        List<OrderDTOListOfEachUser> orderDTOListOfEachUser = new ArrayList<>();
        for (User user:users) {
            OrderDTOList order = orderListOfUserByEvent(user.getId(), eventId);
            if (orderDAO.selectOrderList(user.getId(), eventId).size() > 0) {
                orderDTOListOfEachUser.add(new OrderDTOListOfEachUser(order, user.getEmail()));

            }
        }
        return  orderDTOListOfEachUser;
    }
}
