package com.dataLayer.Implementations;

import com.dataLayer.DAO.RestaurantDAO;
import com.model.Restaurant;
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
public class RestaurantDAOImpl implements RestaurantDAO{
    @Autowired
    SessionFactory sessionFactory ;

    public void save(Restaurant restaurant) {
        Session session = sessionFactory.getCurrentSession();
        session.save(restaurant);
    }

    public List<Restaurant> getListOfAllRestaurant() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from restaurant");
        return (List<Restaurant>) query.list();
    }

    public Restaurant getRestaurantByName(String restaurantName) {
        return null;
    }
}
