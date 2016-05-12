package com.dataLayer.DAO.Implementations;

import com.dataLayer.DAO.Interfaces.ItemDAO;
import com.dataLayer.entity.Item;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class ItemDAOImpl implements ItemDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(Item item) {
        Session session = sessionFactory.getCurrentSession();
        session.save(item);
    }

    @Override
    public Item getItemById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from item where id = :id");
        return (Item) query.setInteger("id",id).uniqueResult();
    }

    @Override
    public void updatePrice(int id, BigDecimal price){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update item set price=:price where id = :id");
        query
                .setBigDecimal("price",price)
                .setInteger("id",id);
        query.executeUpdate();
    }

    @Override
    public void updateName(int id, String name){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update item set name=:name where id = :id");
        query
                .setString("name",name)
                .setInteger("id",id);
        query.executeUpdate();
    }

    @Override
    public void updateDescription(int id, String description){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update item set description=:description where id = :id");
        query
                .setString("description",description)
                .setInteger("id",id);
        query.executeUpdate();
    }
}
