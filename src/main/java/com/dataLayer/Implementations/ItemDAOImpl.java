package com.dataLayer.Implementations;

import com.dataLayer.DAO.ItemDAO;
import com.model.Entity.Item;
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
    SessionFactory sessionFactory ;

    @Override
    public void save(Item item) {
        Session session = sessionFactory.getCurrentSession();
        session.save(item);
    }

    @Override
    public Item getItemById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from menu where id = :id");
        return (Item) query.setInteger("id",id).uniqueResult();
    }

    @Override
    public void updatePrice(int id, BigDecimal price){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update menu set price=:price where id = :id");
        query
                .setBigDecimal("price",price)
                .setInteger("id",id);
        query.executeUpdate();
    }
}
