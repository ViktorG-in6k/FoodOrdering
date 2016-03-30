package com.serviceLayer.implementation;


import java.time.LocalDate;

import java.util.List;
import com.dataLayer.DAO.EventDAO;
import com.model.Event;
import com.serviceLayer.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventDAO eventDAO;

    public void save(Event e) {
        eventDAO.save(e);
    }

    public List<Event> getListOfAllEvents() {
        return eventDAO.getListOfAllEvents();
    }

    public List<Event> getListOfEvents(String eventName) {
        return eventDAO.getListOfEvents(eventName);
    }

    public List<Event> getListOfEventsByDate(LocalDate eventDate) {
        return eventDAO.getListOfEventsByDate(eventDate);
    }

    public List<Event> getListOfEventsByNameAndDate(String eventName, LocalDate eventDate) {
        return eventDAO.getListOfEventsByNameAndDate(eventName,eventDate);
    }

    public List<Event> getListOfEventsBetweenTwoDates(LocalDate firstDate, LocalDate lastDate) {
        return eventDAO.getListOfEventsBetweenTwoDates(firstDate,lastDate);
    }
}
