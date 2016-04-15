package com.dataLayer.Implementations;

import com.dataLayer.DAO.MenuDAO;
import com.model.Item;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class MenuDAOImpl implements MenuDAO{
    @Autowired
    SessionFactory sessionFactory ;

    public void save(Item item) {
        Session session = sessionFactory.getCurrentSession();
        session.save(item);
    }

    public Item getItemById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from menu where id = :id");
        return (Item) query.setInteger("id",id).uniqueResult();
    }
}
