package com.dataLayer.Implementations;

import com.dataLayer.DAO.EventUserDAO;
import com.model.EventUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class EventUserDAOImpl implements EventUserDAO {
    @Autowired
    SessionFactory sessionFactory ;

    public void save(EventUser eventUser) {
        Session session = sessionFactory.getCurrentSession();
        session.save(eventUser);
    }
}
