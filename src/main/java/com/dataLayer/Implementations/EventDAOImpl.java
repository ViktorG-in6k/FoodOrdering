package com.dataLayer.Implementations;

import com.dataLayer.DAO.EventDAO;
import com.model.Event;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class EventDAOImpl implements EventDAO {
    @Autowired
    SessionFactory sessionFactory ;

    public void save(Event e) {
        Session session = sessionFactory.getCurrentSession();
        session.save(e);
    }

    public List<Event> getListOfAllEvents() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from event");
        return (List<Event>) query.list();
    }

    public List<Event> getListOfEvents(String eventName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from event where name = :eventName");
        return (List<Event>) query.setString("eventName",eventName).list();
    }

    public List<Event> getListOfEventsByDate(LocalDate eventDate) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from event where date = :eventDate");
        return (List<Event>) query.setDate("eventDate",java.sql.Date.valueOf(eventDate)).list();
    }

    public List<Event> getListOfEventsByNameAndDate(String eventName, LocalDate eventDate) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from event where name = :eventName and date = :eventDate");
        return (List<Event>) query
                .setString("eventName",eventName)
                .setDate("eventDate",java.sql.Date.valueOf(eventDate)).list();
    }

    public List<Event> getListOfEventsBetweenTwoDates(LocalDate firstDate, LocalDate lastDate) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from event where date between convert(datetime,:firstDate) and convert(datetime,:lastDate)");
        return (List<Event>) query
                .setDate("firstDate",java.sql.Date.valueOf(firstDate))
                .setDate("lastDate",java.sql.Date.valueOf(lastDate)).list();
    }
}
