package com.dataLayer.Implementations;

import com.dao.Interfaces.UserDAO;
import com.model.user;
import org.hibernate.Query;
import org.hibernate.Session;


public class UserDAOImpl implements UserDAO {



    public void save(user person){
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }

    public user getUser(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from user where id = :id");
        return (user) query.setLong("id",id).uniqueResult();
    }

    public user getUserByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from user where email = :email");
        return (user) query.setString("email",email).uniqueResult();
    }
}
