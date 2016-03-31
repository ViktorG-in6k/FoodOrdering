package com.dataLayer.DAO;

import com.model.Event;

import java.time.LocalDate;
import java.util.List;


public interface EventDAO {

    public void save(Event e);
    public List<Event> getListOfAllEvents();
    public List<Event> getListOfEvents(String eventName);
    public List<Event> getListOfEventsByDate(LocalDate eventDate);
    public List<Event> getListOfEventsByNameAndDate(String eventName, LocalDate eventDate);
    public List<Event> getListOfEventsBetweenTwoDates(LocalDate firstDate, LocalDate lastDate);

}
