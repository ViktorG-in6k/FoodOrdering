package com.dataLayer.DAO.Implementations;

import com.dataLayer.DAO.Interfaces.UserDAO;
import com.dataLayer.entity.base.User;
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
public class UserDAOImpl implements UserDAO {
    @Autowired
    SessionFactory sessionFactory;

    public void save(User person) {
        Session session = sessionFactory.getCurrentSession();
        session.save(person);
    }

    public User getUser(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from user where id = :id");
        return (User) query.setLong("id", id).uniqueResult();
    }

    public User getUserByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from user where email = :email");
        return (User) query.setString("email", email).uniqueResult();
    }

    public User findUsersByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from user where email = :email");
        return (User) query.setString("email", email).uniqueResult();
    }

    public List<User> getListOfAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from user");
        return (List<User>) query.list();
    }

    @Override
    public List<User> getListOfUsersByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from user where name LIKE :name or familyName like :name");
        query.setString("name", "%" + name + "%");
        return (List<User>) query.list();
    }
}

