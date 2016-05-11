package com.serviceLayer.implementation;

import com.DTOLayer.DTOEntity.eventDTO.RequestEventDTO;
import com.dataLayer.DAO.EventDAO;
import com.model.Entity.Event;
import com.serviceLayer.service.EventService;
import com.serviceLayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventDAO eventDAO;
    @Autowired
    UserService userService;

    @Override
    public void save(RequestEventDTO eventDTO) {
        Event newEvent = new Event(eventDTO);
        eventDAO.save(newEvent);
    }

    @Override
    public void save(RequestEventDTO eventDTO, int userId) {
        Event newEvent = new Event(eventDTO);
        newEvent.setUser(userService.getUser(userId));
        eventDAO.save(newEvent);
    }

    @Override
    public void saveByRequest(HttpServletRequest req) {
        String name = req.getParameter("name");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime date = LocalDateTime.parse(req.getParameter("date"), formatter);

        Event event = new Event(name, date);
        eventDAO.save(event);
    }

    @Override
    public Event getEventById(int id) {
        return eventDAO.getEventById(id);
    }

    @Override
    public Set<Event> getListOfAllEvents() {
        return eventDAO.getListOfAllEvents();
    }

    @Override
    public List<Event> getListOfEvents(String eventName) {
        return eventDAO.getListOfEvents(eventName);
    }

    @Override
    public List<Event> getListOfEventsByDate(LocalDate eventDate) {
        return eventDAO.getListOfEventsByDate(eventDate);
    }

    @Override
    public List<Event> getListOfEventsByNameAndDate(String eventName, LocalDate eventDate) {
        return eventDAO.getListOfEventsByNameAndDate(eventName, eventDate);
    }

    @Override
    public List<Event> getListOfEventsBetweenTwoDates(LocalDate firstDate, LocalDate lastDate) {
        return eventDAO.getListOfEventsBetweenTwoDates(firstDate, lastDate);
    }

    @Override
    public void update(Event event) {
        eventDAO.update(event);
    }

    @Override
    public void setResponsibleUser(int userId, int eventId) {
        Event eventById = getEventById(eventId);
        eventById.setUser(userService.getUser(userId));
        update(eventById);
    }
}

