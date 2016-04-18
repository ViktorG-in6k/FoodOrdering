package com.dataLayer.Implementations;

import com.DTOLayer.DTOEntity.OrderDTO;
import com.dataLayer.DAO.OrderDAO;
import com.model.Entity.Order;
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
                .setLong("userId",userId)
                .setLong("eventId",eventId)
                .list();
    }

    @Override
    public List<Order> orderListOfEvent(int eventId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from order_list where event_id=:eventId");
        return (List<Order>) query
                .setLong("eventId",eventId)
                .list();
    }


    public Order SelectOrder(int userId,int eventId,int itemId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from order_list where event_id=:eventId and user_id=:userId and item_id=:itemId");
        return (Order) query
                .setInteger("eventId",eventId)
                .setInteger("userId",userId)
                .setInteger("itemId",itemId);
    }

    @Override
    public void deleteItemFromOrder(int userId,int eventId,int itemId) {
        Session session = sessionFactory.getCurrentSession();


        Query query = session.createQuery("delete from order_list where event_id=:eventId and user_id=:userId and item_id=:itemId");
        query
                .setInteger("eventId",eventId)
                .setInteger("userId",userId)
                .setInteger("itemId",itemId);
        query.executeUpdate();
    }

    @Override
    public void updateOrderedOfOrder(boolean ordered,int eventId,int itemId) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("update order_list SET ordered=:ordered where event_id=:eventId and item_id=:itemId");
        query
                .setBoolean("ordered",ordered)
                .setInteger("eventId",eventId)
                .setInteger("itemId",itemId);
        query.executeUpdate();
    }
}
