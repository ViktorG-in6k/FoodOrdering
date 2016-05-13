package com.dataLayer.DAO.Implementations;

import com.dataLayer.DAO.Interfaces.EventDAO;
import com.dataLayer.entity.base.Event;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class EventDAOImpl implements EventDAO {
    @Autowired
    SessionFactory sessionFactory;

    public void save(Event e) {
        Session session = sessionFactory.getCurrentSession();
        session.save(e);
    }

    public Event getEventById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from event where id = :id");
        return (Event) query.setInteger("id", id).uniqueResult();
    }

    public Set<Event> getListOfAllEvents() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from event");
        Set<Event> myEvents = new HashSet<Event>(query.list());

        return myEvents;
    }

    public List<Event> getListOfEvents(String eventName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from event where name = :eventName");
        return (List<Event>) query.setString("eventName", eventName).list();
    }

    public List<Event> getListOfEventsByDate(LocalDate eventDate) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from event where date = :eventDate");
        return (List<Event>) query.setDate("eventDate", java.sql.Date.valueOf(eventDate)).list();
    }

    public List<Event> getListOfEventsByNameAndDate(String eventName, LocalDate eventDate) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from event where name = :eventName and date = :eventDate");
        return (List<Event>) query
                .setString("eventName", eventName)
                .setDate("eventDate", java.sql.Date.valueOf(eventDate)).list();
    }

    @Override
    public List<Event> getListOfEventsBetweenTwoDates(LocalDate firstDate, LocalDate lastDate) {
        return null;
    }

    @Override
    public void update(Event event) {
        sessionFactory.getCurrentSession().update(event);
    }
}

