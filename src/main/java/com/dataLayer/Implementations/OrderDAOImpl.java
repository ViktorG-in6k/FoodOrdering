package com.dataLayer.Implementations;

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

    @Override
    public void save(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.save(order);
    }

    @Override
    public Order getOrderByEventIdAndRestaurantIdAndPayerId(int eventId, int restaurantId, int payerId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from order_info where event_id = :eventId and restaurant_id = :restaurantId and payer_id = :payerId");
        return (Order) query
                .setInteger("eventId", eventId)
                .setInteger("restaurantId", restaurantId)
                .setInteger("payerId", payerId)
                .uniqueResult();
    }

    @Override
    public Order getOrdersByEventIdAndRestaurantId(int eventId, int restaurantId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from order_info where event_id = :eventId and restaurant_id = :restaurantId");
        return (Order) query
                .setInteger("eventId", eventId)
                .setInteger("restaurantId", restaurantId)
                .uniqueResult();
    }

    @Override
    public Order getOrderByOrderId(int orderId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from order_info where id = :orderId");
        return (Order) query
                .setInteger("orderId", orderId)
                .uniqueResult();
    }

    @Override
    public List<Order> getOrdersByEventId(int eventId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from order_info where event_id = :eventId");
        return (List<Order>) query
                .setInteger("eventId", eventId)
                .list();
    }

    @Override
    public List<Order> getOrdersByRestaurantId(int restaurantId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from order_info where restaurant_id = :restaurantId");
        return (List<Order>) query
                .setInteger("restaurantId", restaurantId)
                .list();
    }

    @Override
    public void setPayerForOrder(int orderId, int payerId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update order_info set payer_id=:payerId where id = :orderId");
        query
                .setInteger("orderId", orderId)
                .setInteger("payerId", payerId);
        query.executeUpdate();
    }

    @Override
    public void setPayerForOrder(int eventId, int restaurantId, int payerId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update order_info set payer_id=:payerId where event_id = :eventId and restaurant_id = :restaurantId");
        query
                .setInteger("restaurantId", restaurantId)
                .setInteger("eventId", eventId)
                .setInteger("payerId", payerId);
        query.executeUpdate();
    }
}


