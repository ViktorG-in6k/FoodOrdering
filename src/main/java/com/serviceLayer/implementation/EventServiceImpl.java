package com.serviceLayer.implementation;

import com.dataLayer.entity.DTO.eventDTO.RequestEventDTO;
import com.dataLayer.DAO.Interfaces.EventDAO;
import com.dataLayer.entity.Event;
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
    public Event getEventById(int id) {
        return eventDAO.getEventById(id);
    }

    @Override
    public Set<Event> getListOfAllEvents() {
        return eventDAO.getListOfAllEvents();
    }

    @Override
    public void update(Event event) {
        eventDAO.update(event);
    }
}

