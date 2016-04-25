package com.serviceLayer.service;

import com.DTOLayer.DTOEntity.RequestEventDTO;
import com.model.Entity.Event;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


public interface EventService {
    public void save(RequestEventDTO e);

    public void saveByRequest(HttpServletRequest req);

    public Event getEventById(int id);

    public Set<Event> getListOfAllEvents();

    public List<Event> getListOfEvents(String eventName);

    public List<Event> getListOfEventsByDate(LocalDate eventDate);

    public List<Event> getListOfEventsByNameAndDate(String eventName, LocalDate eventDate);

    public List<Event> getListOfEventsBetweenTwoDates(LocalDate firstDate, LocalDate lastDate);

    public void setResponsibleUser(int userId, int eventId);

    public void update(Event event);
}

