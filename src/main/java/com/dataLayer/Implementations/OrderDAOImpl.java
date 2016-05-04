package com.dataLayer.Implementations;

import com.DTOLayer.DTOEntity.OrderDTO;
import com.dataLayer.DAO.OrderDAO;
import com.model.Entity.Event;
import com.model.Entity.Item;
import com.model.Entity.Order;
import com.model.Entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class OrderDAOImpl implements OrderDAO {
    @Autowired
    SessionFactory sessionFactory;

    public void save(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.save(order);
    }

    @Override
    public List<Order> orderListOfUserByEvent(int userId, int eventId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from order_list where user_id = :userId and event_id=:eventId");
        return (List<Order>) query
                .setLong("userId", userId)
                .setLong("eventId", eventId)
                .list();
    }

    @Override
    public List<Order> orderListOfEvent(int eventId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from order_list where event_id=:eventId");
        return (List<Order>) query
                .setLong("eventId", eventId)
                .list();
    }

    @Override
    public List<Order> selectOrderList(int userId, int eventId, int itemId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from order_list where event_id=:eventId and user_id=:userId and item_id=:itemId");
        return (List<Order>) query
                .setInteger("eventId", eventId)
                .setInteger("userId", userId)
                .setInteger("itemId", itemId).list();
    }

    @Override
    public List<Order> selectOrderList(int userId, int eventId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from order_list where event_id=:eventId and user_id=:userId");
        return (List<Order>) query
                .setInteger("eventId", eventId)
                .setInteger("userId", userId)
                .list();
    }

    @Override
    public void deleteOneItemFromOrder(int userId, int eventId, int itemId) {
        Session session = sessionFactory.getCurrentSession();
        Order order = selectOrderList(userId, eventId, itemId).get(0);
        session.delete(order);
    }

    @Override
    public void deleteItemFromOrder(int userId, int eventId, int itemId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from order_list where event_id=:eventId and user_id=:userId and item_id=:itemId");
        query
                .setInteger("eventId", eventId)
                .setInteger("userId", userId)
                .setInteger("itemId", itemId);
        query.executeUpdate();
    }

    @Override
    public void deleteOneItemFromOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(order);
    }

    @Override
    public void updateOrderedOfOrder(boolean ordered, int eventId, int itemId) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("update order_list SET ordered=:ordered where event_id=:eventId and item_id=:itemId");
        query
                .setBoolean("ordered", ordered)
                .setInteger("eventId", eventId)
                .setInteger("itemId", itemId);
        query.executeUpdate();
    }

    @Override
    public void saveNumberItemToOrder(User user, Item item, Event event, int number) {
        Session session = sessionFactory.getCurrentSession();
        for (int i = 0; i < number; i++) {
            session.save(new Order(user, item, event));
        }
    }

    @Override
    public void deleteNumberItemFromOrder(int userId, int eventId, int itemId, int number) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("DELETE FROM order_list WHERE id IN (SELECT id from (select id\n" +
                "            FROM order_list WHERE event_id = " + eventId + " and item_id = " + itemId + " AND order_list.user_id = " + userId +
                "            LIMIT " + number + ") x)");
        query.executeUpdate();

    }
}

