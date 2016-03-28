package com.dataLayer.Implementations;

import com.dataLayer.DAO.UserDAO;
import com.model.user;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
    @Autowired
    SessionFactory sessionFactory ;

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
