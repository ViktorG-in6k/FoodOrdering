package com.serviceLayer.service;

import com.model.Event;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;


public interface EventService {
    public void save(Event e);
    public List<Event> getListOfAllEvents();
    public List<Event> getListOfEvents(String eventName);
    public List<Event> getListOfEventsByDate(LocalDate eventDate);
    public List<Event> getListOfEventsByNameAndDate(String eventName, LocalDate eventDate);
    public List<Event> getListOfEventsBetweenTwoDates(LocalDate firstDate, LocalDate lastDate);
}
