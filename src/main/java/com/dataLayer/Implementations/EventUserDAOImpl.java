package com.dataLayer.Implementations;

import com.dataLayer.DAO.EventUserDAO;
import com.model.EventUser;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class EventUserDAOImpl implements EventUserDAO {
    @Autowired
    SessionFactory sessionFactory;

    public void save(EventUser eventUser) {
        Session session = sessionFactory.getCurrentSession();
        session.save(eventUser);
    }

    public EventUser getEventUserById(int user_id, int event_id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from event_list where user_id = :user_id and event_id =:event_id");
        query.setInteger("user_id", user_id);
        query.setInteger("event_id", event_id);
        return (EventUser) query.uniqueResult();
    }
}
