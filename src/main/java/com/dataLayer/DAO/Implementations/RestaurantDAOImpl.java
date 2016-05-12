package com.dataLayer.DAO.Implementations;

import com.dataLayer.DAO.Interfaces.RestaurantDAO;
import com.dataLayer.entity.Item;
import com.dataLayer.entity.Restaurant;
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
public class RestaurantDAOImpl implements RestaurantDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(Restaurant restaurant) {
        Session session = sessionFactory.getCurrentSession();
        session.save(restaurant);
    }

    @Override
    public List<Restaurant> getListOfAllRestaurant() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from restaurant");
        return (List<Restaurant>) query.list();
    }

    @Override
    public Restaurant getRestaurantByName(String restaurantName) {
        return null;
    }

    @Override
    public Restaurant getRestaurantById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from restaurant where id = :id");
        return (Restaurant) query.setInteger("id", id).uniqueResult();
    }

    @Override
    public List<Item> getRestaurantMenuById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from restaurant where id = :id");
        return (List<Item>) query.setInteger("id", id).list();
    }

    @Override
    public void updateName(int id, String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update restaurant set name=:name where id = :id");
        query
                .setString("name", name)
                .setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public void updateDescription(int id, String phone) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update restaurant set phone=:description where id = :id");
        query
                .setString("description", phone)
                .setInteger("id", id);
        query.executeUpdate();
    }
}

