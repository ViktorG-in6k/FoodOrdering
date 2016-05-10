package com.dataLayer.Implementations;

import com.dataLayer.DAO.OrderItemDAO;
import com.model.Entity.OrderItem;
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
public class OrderItemDAOImpl implements OrderItemDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveOrderItem(OrderItem orderItem) {
        Session session = sessionFactory.getCurrentSession();
        session.save(orderItem);
    }

    @Override
    public OrderItem getOrderItem(int userId, int itemId, int orderId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from order_item where order_id = :orderId and item_id = :itemId and user_id = :userId");
        return (OrderItem) query
                .setInteger("userId", userId)
                .setInteger("itemId", itemId)
                .setInteger("orderId", orderId)
                .uniqueResult();
    }

    @Override
    public List<OrderItem> getOrderListByOrderIdAndUserId(int userId, int orderId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from order_item where order_id = :orderId and user_id = :userId");
        return (List<OrderItem>) query
                .setInteger("userId", userId)
                .setInteger("orderId", orderId)
                .list();
    }

    @Override
    public void updateAmount(OrderItem orderItem, int amount) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update order_item SET item_amount=:amount where order_id=:orderId and item_id=:itemId and user_id=:userId");
        query
                .setInteger("amount", amount)
                .setInteger("orderId", orderItem.getOrder().getId())
                .setInteger("itemId", orderItem.getItem().getId())
                .setInteger("userId", orderItem.getUser().getId());
        query.executeUpdate();
    }
}

