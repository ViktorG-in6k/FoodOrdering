package com.dataLayer.Implementations;

import com.dataLayer.DAO.OrderDAO;
import com.model.Order;
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
}
